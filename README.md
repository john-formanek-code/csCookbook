# csCookbook

Coursework from school, organized by subject.

## Structure

- `apv/` — APV
  - `my-work/` — my own exercises, organized by topic: `access` (Access/database exercises, one per assignment), `excel`, `powerpoint`, `styly_word`, `ostatni`
- `moa/` — MOA
  - `my-work/` — my own projects (JS/PWA exercises), organized by topic: `01_zaklady`, `02_kalkulatory_matika_fyzika`, `03_hry`, `04_pwa_s_databazi`, `05_pocasi_api`
  - `johanovsky/` — forks of the teacher's course repos (submodules)
- `prm-pva/` — PRM and PVA (same subject in practice, split by language taught)
  - `java/my-work/src/` — my own Java exercises, organized by topic (`01_zaklady` … `15_sql`). `16_mini_projekty` is only for things with no single topic (a JavaFX GUI project, one broken fragment) — everything else (file I/O, OOP, sorting, etc.) lives under its matching numbered topic even when it came from a larger multi-file project. `_ke_smazani` is junk.
  - `java/johanovsky/` — fork of the teacher's PRM3 repo (submodule)
  - `php/my-work/` — my own PHP exercises, organized by topic: `01_zaklady`, `02_funkce_include`, `03_formulare_get_post`, `04_algoritmy_s_formularem`, `05_cookies_a_session`, `_ke_smazani`
  - `sql/my-work/` — SQL dumps/exercises
  - `vba/teorie/` — VBA theory materials (slides, docs)
- `zzd/` — ZZD (Excel/VBA)
  - `zadani/` — assignments
  - `reseni/` — solved exercises
  - `vba/` — macro-enabled projects
  - `data/` — source data files
- `zmm/` — ZMM (Photoshop lesson material)
- `zpr/` — ZPR (HTML/CSS coursework)
  - `my-work/` — my own exercises, organized by topic: `01_css`, `02_formulare`, `03_frameset`, `04_tabulky`, `05_projekty`, `06_teorie`, `_mimo_temata` (old unrelated DOS utilities)
- `freshman-year/` — first-year material spanning multiple subjects that doesn't map to a single subject folder above: `01_apv`, `02_cestina`, `03_ict` (split into `cviceni`, `dokumenty`, `excel`), `04_matika`, `05_prezentace`, `06_prochazka`

No split by year — subjects stay together regardless of which year they were taken, except `freshman-year/`, which predates the subject-based split.

## Git LFS

`zmm/` holds Photoshop lesson files (`.psd`, `.docx`, `.pptx`, `.ai`, `.abr`, `.otf`, `.db`), tracked via Git LFS instead of as regular blobs — see `.gitattributes`. Clone with Git LFS installed, or run `git lfs pull` after cloning to fetch the actual file contents.

## Submodules

The `johanovsky/` folders are git submodules pointing at forks of the teacher's repos, not copies. After cloning:

```
git submodule update --init --recursive
```

## Keeping the forks current

`.github/workflows/sync-johanovsky-forks.yml` runs daily. It syncs each fork with the teacher's upstream repo, updates the submodule pointers, and commits if anything changed. It needs a `FORK_SYNC_PAT` repository secret (fine-grained PAT with contents read/write on the forked repos) to do the sync step.
