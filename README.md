# My Works
A  Place to hold my projects

> **Legacy archive.** This repository holds early EvoveMedia coursework (2007–2021): the JavaFlix
> rental-store app in Java Swing and a few VB.NET forms. It is kept for reference only.
> Active EvolveMedia Technology (EMT) platform work (data platform, infrastructure, CI/CD) now lives in the
> private repository **`emt-infrastructure`**. Access is by invitation.

## Build and run (JDK 17+)

```bash
./build.sh            # or: powershell -File build.ps1   (compiles everything, runs the 19-check smoke test)
java -cp out javaflix.JavaFlix
```

| Folder | Contents |
|---|---|
| `src/javaflix/` | JavaFlix rental app: `Customer`, `Address`, `DVD` → `Movie` → `Concert`, `Game`, `FlixQueue` (3-movie queue), `JavaFlix` (staff GUI), `Add_Item` (inventory window), `SmokeTest` |
| `src/exercises/` | Console exercises: `Assignmemt09`, `NumFile` (reads `Number.txt`), `Temperature`, `Inventory` + `InventoryDemo` (`java -cp out exercises.InventoryDemo`) |
| `vb/` | VB.NET Windows Forms (stadium seats, MPH, Roman numerals). Source only: there's no `.vbproj`, so add the files to a Visual Studio Windows Forms project to run them. |

GitHub Actions (`.github/workflows/java.yml`) compiles the Java and runs the smoke test on every push.
