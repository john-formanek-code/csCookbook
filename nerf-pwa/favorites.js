var favoritesList = null;

window.onload = async function() {
  await initDB();
  registerServiceWorker();

  favoritesList = document.getElementById('favoritesList');
  await showFavorites();
};

async function showFavorites() {
  var favorites = await getAllFavorites();

  if (favorites.length === 0) {
    favoritesList.innerHTML = '<p class="empty-message">Zatím nejsou uloženy žádné oblíbené kombinace.</p>';
    return;
  }

  var html = '';

  for (var i = 0; i < favorites.length; i++) {
    var item = favorites[i];

    html += '<div class="favorite-row">';
    html += '<button class="favorite-pick" onclick="openFavorite(\'' + item.primary + '\', \'' + item.secondary + '\')">';
    html += item.primary + ' + ' + item.secondary;
    html += '</button>';
    html += '<button class="delete-btn" onclick="removeFavorite(' + item.id + ')">Smazat</button>';
    html += '</div>';
  }

  favoritesList.innerHTML = html;
}

function openFavorite(primary, secondary) {
  window.location.href = 'index.html?primary=' + encodeURIComponent(primary) + '&secondary=' + encodeURIComponent(secondary);
}

async function removeFavorite(id) {
  await deleteFavorite(id);
  await showFavorites();
}

function registerServiceWorker() {
  if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('sw.js');
  }
}
