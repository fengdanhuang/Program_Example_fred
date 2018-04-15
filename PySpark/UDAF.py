



import logging
import pandas as pd


_logger = logging.getLogger(__name__)


def rows_to_pandas(rows):
    """Converts a Spark Row iterator of a partition to a Pandas DataFrame assuming YARN

    Args:
        rows: iterator over PySpark Row objects

    Returns:
        Pandas DataFrame
    """
    first_row, rows = peek(rows)
    if not first_row:
        _logger.warning("Spark DataFrame is empty! Returning empty Pandas DataFrame!")
        return pd.DataFrame()

    first_row_info = ["{} ({}): {}".format(k, rtype(first_row[k]), first_row[k])
                      for k in first_row.__fields__]
    _logger.debug("First partition row: {}".format(first_row_info))
    df = pd.DataFrame.from_records(rows, columns=first_row.__fields__)
    _logger.debug("Converted partition to DataFrame of shape {} with types:\n{}".format(df.shape, df.dtypes))
    return df



