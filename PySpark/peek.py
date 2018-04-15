



import numpy as np
from pyspark.sql.types import Row


def convert_dtypes(rows):
    """Converts some Pandas data types to pure Python data types

    Args:
        rows (array): numpy recarray holding all rows

    Returns:
        Iterator over lists of row values
    """
    dtype_map = {pd.Timestamp: lambda x: x.to_pydatetime(),
                 np.int8: lambda x: int(x),
                 np.int16: lambda x: int(x),
                 np.int32: lambda x: int(x),
                 np.int64: lambda x: int(x),
                 np.float16: lambda x: float(x),
                 np.float32: lambda x: float(x),
                 np.float64: lambda x: float(x),
                 np.float128: lambda x: float(x)}
    for row in rows:
        yield [dtype_map.get(type(elem), lambda x: x)(elem) for elem in row]


def pandas_to_rows(df):
    """Converts Pandas DataFrame to iterator of Row objects

    Args:
        df: Pandas DataFrame

    Returns:
        Iterator over PySpark Row objects
    """
    if df is None:
        _logger.debug("Returning nothing")
        return iter([])
    if type(df) is pd.Series:
        df = df.to_frame().T
    if df.empty:
        _logger.warning("Pandas DataFrame is empty! Returning nothing!")
        return iter([])
    _logger.debug("Convert DataFrame of shape {} to partition with types:\n{}".format(df.shape, df.dtypes))
    records = df.to_records(index=False)
    records = convert_dtypes(records)
    first_row, records = peek(records)
    first_row_info = ["{} ({}): {}".format(k, rtype(v), v) for k, v in zip(df.columns, first_row)]
    _logger.debug("First record row: {}".format(first_row_info))
    row = Row(*df.columns)
    return (row(*elems) for elems in records)
