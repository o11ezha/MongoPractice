#!/usr/bin/env bash
mongo --eval "sh.addShard('R-mongo-shard-01/mongo-shard-1-1:27017,mongo-shard-1-2:27017')";
mongo --eval "sh.addShard('R-mongo-shard-02/mongo-shard-2-1:27017,mongo-shard-2-2:27017')";