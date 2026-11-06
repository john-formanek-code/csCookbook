// Offline PWA - ulozime vsechny soubory a obrazky do cache
const CACHE_NAME = "rivals-v1";
const cacheAssets = [
    "./index.html",
    "./favorites.html",
    "./style.css",
    "./db.js",
    "./app.js",
    "./app_favorites.js",
    "./manifest.json",
    "./icon-192.png",
    "./icon-512.png",
    "./img/Empty.png",
    "./img/BR.png",
    "./img/BR+Skin.png",
    "./img/BR+Wrap.png",
    "./img/BR+Skin+Wrap.png",
    "./img/RPG.png",
    "./img/RPG+Skin.png",
    "./img/RPG+Wrap.png",
    "./img/RPG+Skin+Wrap.png"
];

self.addEventListener("install", event => {
    event.waitUntil(
        caches.open(CACHE_NAME)
        .then(cache => cache.addAll(cacheAssets))
        .then(() => self.skipWaiting())
    );
});

self.addEventListener("activate", event => {
    event.waitUntil(
        caches.keys().then(names => {
            return Promise.all(names.map(name => {
                if(name !== CACHE_NAME) {
                    return caches.delete(name);
                }
            }));
        }).then(() => self.clients.claim())
    );
});

self.addEventListener("fetch", event => {
    if(event.request.method !== "GET") return;
    if(new URL(event.request.url).origin !== self.location.origin) return;

    event.respondWith(
        caches.match(event.request, { ignoreSearch: true })
        .then(response => {
            if(response) return response;
            return fetch(event.request);
        })
    );
});
