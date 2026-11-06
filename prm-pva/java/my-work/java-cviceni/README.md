# java-cviceni (High/3)

Java/algorithms coursework for the 3rd year ("tretak"), migrated from the legacy
`td/` dump (`td/skol`, `td/ukol`, `td/src/tretak`, `td/kaspi/zasobnik`).
Sits alongside the pre-existing loose subject folders in `school/High/3/`
(`prm`, `pva`, `sorts`, `pos`, ...) — same course, just material that had
ended up in `td/` instead.

## Contents

- `skol-2026/` — exercises dated Dec 2025–Jan 2026: file I/O (`Zápis do
  souboru - FileWriter`, `Čtení ze souboru - Scanner`), searching
  (`Vyhledávání...`), sorting (`Řazení...`), and `PRM/` homework. Internal
  structure kept as-is (was already coherent).
- `src-tretak/` — categorized 3rd-year exercises: `algorithms/`,
  `data-structures/`, `oop/`, `file-io/`, `graphics/`, `enums/`,
  `logic-exercises/`, `testing/`, `docs/`, `misc/`. Includes a stray
  `.Rhistory` (empty, harmless leftover).
- `ukoly-2026/` — 4 loose homework files (array/stack exercises, dated April
  2026).
- `zasobnik-classfiles/` — 2 compiled `.class` files only (no `.java`
  source) from `td/kaspi/zasobnik`. The actual source lives in `td/kaspi/`
  (parent folder), which is out of scope for this reorg and was left
  untouched under `td/`.

Note: `school/High/3/MOA-webapps/` (sibling folder) is the same course's
web-app/PWA exercises, migrated separately — see its own README.

## Naming convention

Kept original Czech/course names (skol, ukoly, PRM, etc.) — these are course
artifact names, not worth renaming. Folder suffixes like `-2026` mark the
batch's rough date when a distinguishing name was needed.
