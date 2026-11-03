//pro práci offline a ukládání do cache
const CACHE_NAME = "rivals-v2";
const cacheAssets = [
    "./",
    "./index.html",
    "./favorites.html",
    "./style.css",
    "./db.js",
    "./app.js",
    "./app_favorites.js",
    "./manifest.json",
    "./imgB/Empty.png",
    "./imgB/BR.png",
    "./imgB/BR+Skin.png",
    "./imgB/BR+Wrap.png",
    "./imgB/BR+Skin+Wrap.png",
    "./imgB/RPG.png",
    "./imgB/RPG+Skin.png",
    "./imgB/RPG+Wrap.png",
    "./imgB/RPG+Skin+Wrap.png"
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
        //ignoreSearch -> index.html?weapon=... najde v cache index.html i offline
        caches.match(event.request, {ignoreSearch: true}).then(response => {
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
