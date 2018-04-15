




import os
import sys


def setup_logger(loglevel=logging.INFO, logfile="pyspark.log"):
    """Setup basic logging for logging on the executor

    Args:
        loglevel (int): minimum loglevel for emitting messages
        logfile (str): name of the logfile
    """
    logformat = "%(asctime)s %(levelname)s %(module)s.%(funcName)s: %(message)s"
    datefmt = "%y/%m/%d %H:%M:%S"
    try:
        logfile = os.path.join(os.environ['LOG_DIRS'].split(',')[0], logfile)
    except (KeyError, IndexError):
        logging.basicConfig(level=loglevel,
                            stream=sys.stdout, 
                            format=logformat,
                            datefmt=datefmt)
        logger = logging.getLogger(__name__)
        logger.error("LOG_DIRS is not in environment variables or empty, using STDOUT instead.")

    logging.basicConfig(level=loglevel,
                        filename=logfile,
                        format=logformat,
                        datefmt=datefmt)
