#!/usr/bin/env bash
mongo --eval "rs.initiate({_id: 'R-mongo-shard-02', members: [{_id: 0, host: 'mongo-shard-2-1:27017'}, {_id: 1, host: 'mongo-shard-2-2:27017'}]})"