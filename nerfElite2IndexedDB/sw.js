//pro práci offline a ukládání do cache
const CACHE_NAME = "v2";
const cacheAssets = [
    "./",
    "./index.html",
    "./favorites.html",
    "./style.css",
    "./db.js",
    "./app.js",
    "./app_favorites.js",
    "./manifest.json",
    "./img/Commander.png",
    "./img/Eaglepoint.png",
    "./img/Empty.png",
    "./img/NerfElite2_logo.png",
    "./img/Phoenix.png",
    "./img/Turbine.png",
    "./img/Volt.png",
    "./img/Warden.png"
];
self.addEventListener("install", e => {
    e.waitUntil(
        caches.open(CACHE_NAME)
            .then(cache => {
                console.log("Caching files");
                return cache.addAll(cacheAssets);
            })
            .then(() => self.skipWaiting())
    );
});

self.addEventListener("activate", e => {
    e.waitUntil(
        caches.keys().then(cacheNames => {
            return Promise.all(
                cacheNames.map(cache => {
                    if (cache !== CACHE_NAME) {
                        console.log("Removing old cache", cache);
                        return caches.delete(cache);
                    }
                })
            );
        })
    );
});

self.addEventListener("fetch", event => {
    event.respondWith(
        caches.match(event.request).then(response => {
            if (response) {
                return response;
            }
            return fetch(event.request).then(networkResponse => {
                const responseClone = networkResponse.clone();
                caches.open(CACHE_NAME).then(cache => {
                    cache.put(event.request, responseClone);
                });
                return networkResponse;
            });
        }).catch(() => {
            console.log("Offline and no cache");
        })
    );
});
