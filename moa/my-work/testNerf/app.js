(() => {
  const img    = document.getElementById('blaster');
  const scope  = document.getElementById('scope');
  const barrel = document.getElementById('barrel');

  // 0 base, 1 barrel, 2 scope, 3 scope+barrel (cesty ponechány!)
  const IMGS = [
    'images/LongStrike.png',
    'images/LongStrikeWithBarrel.png',
    'images/LongStrikeWithScope.png',
    'images/LongStrikeWithScopeAndBarrel.png'
  ];

  IMGS.forEach(src => (new Image()).src = src);

  function render() {
    let next;
    
    if (scope.checked && barrel.checked) {
      next = IMGS[3];
    } else if (scope.checked) {
      next = IMGS[2];
    } else if (barrel.checked) {
      next = IMGS[1];
    } else {
      next = IMGS[0];
    }
c
    if (img.getAttribute('src') !== next) {
      img.style.opacity = '0.001';
      requestAnimationFrame(() => {
        img.src = next;
        if (img.complete) requestAnimationFrame(() => (img.style.opacity = '1'));
        else img.onload = () => (img.style.opacity = '1');
      });
    }
  }

  [scope, barrel].forEach(el => el.addEventListener('change', render));
  render();

  // Service worker registrace 
  if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
      navigator.serviceWorker.register('./sw.js', { scope: './' }).catch(console.error);
    });
  }
})();
