


import pyspark_udaf
import logging


@pyspark_udaf.pandas_udaf(loglevel=logging.DEBUG)
def my_func(df):
    if df.empty:
        return
    df = df.groupby('country').apply(lambda x: x.drop('country', axis=1).describe())
    return df.reset_index()
