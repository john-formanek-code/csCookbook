# csCookbook

Coursework from school, organized by subject.

## Structure

- `moa/` — MOA
  - `my-work/` — my own projects (JS/PWA exercises)
  - `johanovsky/` — forks of the teacher's course repos (submodules)
- `prm-pva/` — PRM and PVA (same subject in practice, split by language taught)
  - `java/my-work/` — my own Java exercises
  - `java/johanovsky/` — fork of the teacher's PRM3 repo (submodule)
  - `php/my-work/` — my own PHP exercises
  - `vba/teorie/` — VBA theory materials (slides, docs)
- `ZZD/` — ZZD (Excel/VBA)
  - `zadani/` — assignments
  - `reseni/` — solved exercises
  - `vba/` — macro-enabled projects
  - `data/` — source data files

No split by year — subjects stay together regardless of which year they were taken.

## Submodules

The `johanovsky/` folders are git submodules pointing at forks of the teacher's repos, not copies. After cloning:

```
git submodule update --init --recursive
```

## Keeping the forks current

`.github/workflows/sync-johanovsky-forks.yml` runs daily. It syncs each fork with the teacher's upstream repo, updates the submodule pointers, and commits if anything changed. It needs a `FORK_SYNC_PAT` repository secret (fine-grained PAT with contents read/write on the forked repos) to do the sync step.
