



from functools import wraps


class pandas_udaf(object):
    """Decorator for PySpark UDAFs using Pandas

    Args:
        loglevel (int): minimum loglevel for emitting messages
    """
    def __init__(self, loglevel=logging.INFO):
        self.loglevel = loglevel

    def __call__(self, func):
        @wraps(func)
        def wrapper(*args):
            # use *args to allow decorating methods (incl. self arg)
            args = list(args)
            setup_logger(loglevel=self.loglevel)
            args[-1] = rows_to_pandas(args[-1])
            df = func(*args)
            return pandas_to_rows(df)
        return wrapper
