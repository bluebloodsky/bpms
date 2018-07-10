
/* @flow */

export const getRandomInt = (start, end) => {
  return start + Math.floor(Math.random() * (end - start))
}
export const getRandomFloat = (start, end, fixed = 2) => {
  return (start + Math.random() * (end - start)).toFixed(fixed)
}

export const copyObject = (source ) => {
  return JSON.parse(JSON.stringify(source))
}

/**
 * Remove an item from an array
 */
export const remove = (arr , item) => {
  if (arr.length) {
    const index = arr.findIndex(it => {
      return JSON.stringify(it) == JSON.stringify(item)
    })
    if (index > -1) {
      return arr.splice(index, 1)
    }
  }
}

export const rollbackMap = (source, logContents) => {
  for ( let k in logContents){
    if (logContents[k].type == 'add') {
      if (Array.isArray(source)) {
        source.splice(k, 1)
      } else {
        delete source[k]
      }
    } else if (logContents[k].type == 'remove' || logContents[k].type == 'change') {
      source[k] = logContents[k].oldvalue
    } else {
      rollbackMap(source[k], logContents[k])
    }
  }
}

export const rollbackList = (source, logContents) => {
  logContents.map(log => {
    if (log.type == 'add') {
      remove(source, log.newvalue)
    } else if (log.type == 'remove') {
      source.push(log.oldvalue)
    }
  })
}

export const mixObject = (_to, _from) => {
  for (const key in _from) {
    if (_to.hasOwnProperty(key)) {
      if (typeof _from[key] === 'object' && !Array.isArray(_from[key])) {
        _to[key] = mixObject(_to[key], _from[key])
      } else {
        _to[key] = _from[key]
      }
    }
  }
  return _to
}