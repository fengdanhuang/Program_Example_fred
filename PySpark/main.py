

from pyspark.sql.types import *
from pyspark.sql import functions as F
from pyspark import SparkContext
from pyspark.sql import SparkSession


# make pyspark_udaf.py available to the executors
spark.sparkContext.addFile('./pyspark_udaf.py')

df = spark.createDataFrame(
    data = [('DEU', 2, 1.0), ('DEU', 3, 8.0), ('FRA', 2, 6.0),
            ('FRA', 0, 8.0), ('DEU', 3, 8.0), ('FRA', 1, 3.0)],
    schema = ['country', 'feature1', 'feature2'])

stats_df = df.repartition('country').rdd.mapPartitions(my_func).toDF()
print(stats_df.toPandas())


