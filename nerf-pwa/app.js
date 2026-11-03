var primarySelect = null;
var secondarySelect = null;
var primaryImg = null;
var secondaryImg = null;
var saveBtn = null;

var primaryWeapons = ['Empty', 'Eaglepoint', 'Turbine', 'Phoenix'];
var secondaryWeapons = ['Empty', 'Warden', 'Commander', 'Volt'];

window.onload = async function() {
  await initDB();
  registerServiceWorker();

  primarySelect = document.getElementById('primarySelect');
  secondarySelect = document.getElementById('secondarySelect');
  primaryImg = document.getElementById('primaryImg');
  secondaryImg = document.getElementById('secondaryImg');
  saveBtn = document.getElementById('saveBtn');

  primarySelect.onchange = updateImages;
  secondarySelect.onchange = updateImages;
  saveBtn.onclick = saveCurrentLoadout;

  loadFromUrl();
  updateImages();
};

function getImagePath(weaponName) {
  if (!weaponName || weaponName === 'Empty') {
    return 'images/Empty.png';
  }

  return 'images/' + weaponName + '.png';
}

function updateImages() {
  primaryImg.src = getImagePath(primarySelect.value);
  secondaryImg.src = getImagePath(secondarySelect.value);

  primaryImg.alt = primarySelect.value;
  secondaryImg.alt = secondarySelect.value;
}

async function saveCurrentLoadout() {
  var primary = primarySelect.value;
  var secondary = secondarySelect.value;

  if (primary === 'Empty' && secondary === 'Empty') {
    alert('Nelze uložit kombinaci Empty + Empty. Nastav alespoň jednu zbraň.');
    return;
  }

  await addFavorite(primary, secondary);
  alert('Výzbroj byla uložena do oblíbených.');
}

function loadFromUrl() {
  var params = new URLSearchParams(window.location.search);
  var primary = params.get('primary');
  var secondary = params.get('secondary');

  if (primaryWeapons.indexOf(primary) !== -1) {
    primarySelect.value = primary;
  }

  if (secondaryWeapons.indexOf(secondary) !== -1) {
    secondarySelect.value = secondary;
  }
}

function registerServiceWorker() {
  if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('sw.js');
  }
}
