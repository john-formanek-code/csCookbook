var db = null;
var DB_NAME = 'nerf-loadout-db';
var DB_VERSION = 1;
var STORE_NAME = 'favorites';

function initDB() {
  return new Promise(function(resolve, reject) {
    var request = indexedDB.open(DB_NAME, DB_VERSION);

    request.onupgradeneeded = function(event) {
      db = event.target.result;

      if (!db.objectStoreNames.contains(STORE_NAME)) {
        db.createObjectStore(STORE_NAME, {
          keyPath: 'id',
          autoIncrement: true
        });
      }
    };

    request.onsuccess = function(event) {
      db = event.target.result;
      resolve(db);
    };

    request.onerror = function(event) {
      reject(event.target.error);
    };
  });
}

function addFavorite(primary, secondary) {
  return new Promise(function(resolve, reject) {
    var transaction = db.transaction(STORE_NAME, 'readwrite');
    var store = transaction.objectStore(STORE_NAME);

    var record = {
      primary: primary,
      secondary: secondary
    };

    var request = store.add(record);

    request.onsuccess = function() {
      resolve();
    };

    request.onerror = function(event) {
      reject(event.target.error);
    };
  });
}

function getAllFavorites() {
  return new Promise(function(resolve, reject) {
    var transaction = db.transaction(STORE_NAME, 'readonly');
    var store = transaction.objectStore(STORE_NAME);
    var request = store.getAll();

    request.onsuccess = function(event) {
      resolve(event.target.result);
    };

    request.onerror = function(event) {
      reject(event.target.error);
    };
  });
}

function deleteFavorite(id) {
  return new Promise(function(resolve, reject) {
    var transaction = db.transaction(STORE_NAME, 'readwrite');
    var store = transaction.objectStore(STORE_NAME);
    var request = store.delete(id);

    request.onsuccess = function() {
      resolve();
    };

    request.onerror = function(event) {
      reject(event.target.error);
    };
  });
}
