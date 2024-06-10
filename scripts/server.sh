#!/usr/bin/env bash
mongo --eval "rs.initiate({_id: 'R-mongo-server', members: [{_id: 0, host: 'mongo-server-1:27017'}, {_id: 1, host: 'mongo-server-2:27017'}]})"