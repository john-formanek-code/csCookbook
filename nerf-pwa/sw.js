var CACHE_NAME = 'nerf-pwa-cache-v1';

var FILES_TO_CACHE = [
  './',
  './index.html',
  './favorites.html',
  './style.css',
  './db.js',
  './app.js',
  './favorites.js',
  './manifest.webmanifest',
  './images/Commander.png',
  './images/Eaglepoint.png',
  './images/Empty.png',
  './images/NerfElite2_logo.png',
  './images/Phoenix.png',
  './images/Turbine.png',
  './images/Volt.png',
  './images/Warden.png',
  './icons/icon-192.png',
  './icons/icon-512.png'
];

self.addEventListener('install', function(event) {
  event.waitUntil(
    caches.open(CACHE_NAME).then(function(cache) {
      return cache.addAll(FILES_TO_CACHE);
    })
  );
});

self.addEventListener('activate', function(event) {
  event.waitUntil(
    caches.keys().then(function(cacheNames) {
      return Promise.all(
        cacheNames.map(function(cacheName) {
          if (cacheName !== CACHE_NAME) {
            return caches.delete(cacheName);
          }
        })
      );
    })
  );
});

self.addEventListener('fetch', function(event) {
  event.respondWith(
    caches.match(event.request).then(function(response) {
      if (response) {
        return response;
      }

      return fetch(event.request);
    })
  );
});
