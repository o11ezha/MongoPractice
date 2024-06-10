#!/usr/bin/env bash
mongo --eval "rs.initiate({_id: 'R-mongo-shard-01', members: [{_id: 0, host: 'mongo-shard-1-1:27017'}, {_id: 1, host: 'mongo-shard-1-2:27017'}]})"