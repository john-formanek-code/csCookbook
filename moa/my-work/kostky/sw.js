//ulozeni souboru pro offline pouziti
const CACHE_NAME = "kostky-v1";
const cacheAssets = [
    "./index.html",
    "./score.html",
    "./style.css",
    "./db.js",
    "./app.js",
    "./score.js",
    "./manifest.json",
    "./icon-192.png",
    "./icon-512.png"
];

self.addEventListener("install", event => {
    event.waitUntil(
        caches.open(CACHE_NAME).then(cache => cache.addAll(cacheAssets))
    );
    self.skipWaiting();
});

self.addEventListener("activate", event => {
    event.waitUntil(
        caches.keys().then(names => {
            return Promise.all(names.map(name => {
                if (name !== CACHE_NAME) return caches.delete(name);
            }));
        })
    );
    self.clients.claim();
});

self.addEventListener("fetch", event => {
    if (event.request.method !== "GET") return;
    event.respondWith(
        fetch(event.request).catch(() => caches.match(event.request))
    );
});
