# GalaAndroid Agent Notes

## Collaboration Style

This project is being built while the user is learning Android, Jetpack Compose, MVVM, and Navigation Compose.

When helping in this repository:

- Work in small blocks.
- Explain what exists, what is missing, what to change, why it is needed, and how it fits the architecture.
- Do not jump straight to large rewrites unless the user explicitly asks.
- Prefer guiding step by step, then validating the current block before moving to the next one.
- Keep explanations practical and tied to the actual files in this repository.
- When making code changes, keep them scoped and explain the purpose afterward.

The user values understanding the concepts, not only getting working code.

## Current Architecture Direction

The app is following a practical MVVM-style structure inspired by a reference project:

- `data/`: data classes, enums, and repository contracts or temporary sample data.
- `viewmodels/`: screen ViewModels that own UI state and screen actions.
- `views/state/`: `UiState` classes for each screen.
- `views/screens/`: full screen composables.
- `views/components/`: reusable Compose components.
- `navigation/`: routes and the root navigation host.

The main flow should stay:

```text
UI -> ViewModel -> Data
```

Navigation is separate:

```text
MainActivity -> AppHost -> screen routes
```

Do not put navigation logic inside ViewModels or data models.

## Navigation Pattern

Navigation is being implemented with Navigation Compose.

Key files:

- `app/src/main/java/com/drgabo/galaandroid/navigation/AppDestinations.kt`
- `app/src/main/java/com/drgabo/galaandroid/navigation/AppHost.kt`
- `app/src/main/java/com/drgabo/galaandroid/views/components/NavBar.kt`
- `app/src/main/java/com/drgabo/galaandroid/views/components/ScaffoldPrincipal.kt`

The intended responsibility split is:

- `AppHost` owns the real `NavController`.
- `AppHost` derives `currentRoute`.
- `AppHost` defines `onNavigate`.
- Screens receive `currentRoute` and `onNavigate`.
- `ScaffoldPrincipal` forwards those values to `NavBar`.
- `NavBar` only renders tabs and calls `onNavigate(route)`.

Do not create a separate `rememberNavController()` inside `NavBar`.

For top-level tabs, use this navigation pattern:

```kotlin
val onNavigate: (String) -> Unit = { route ->
    if (route != currentRoute) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
```

Explain this pattern when relevant:

- `if (route != currentRoute)`: avoids navigating to the same screen again.
- `popUpTo(...)`: prevents top-level tabs from growing the back stack endlessly.
- `saveState = true`: keeps state when leaving a tab.
- `launchSingleTop = true`: avoids duplicate copies of the same destination.
- `restoreState = true`: restores saved tab state when returning.

## Current Navigation State

The app currently has five bottom nav destinations:

- `OWNER_DASHBOARD`
- `OWNER_AGENDA`
- `OWNER_SERVICES`
- `OWNER_CLIENTS`
- `OWNER_MORE`

`Servicios` and `Mas` are provisional placeholder destinations for demonstration. They should remain visible in the bottom navigation.

Before adding more complex navigation, verify:

- All five tabs navigate without crashing.
- The selected tab follows `currentRoute`.
- Repeatedly tapping the same tab does not duplicate destinations.
- The app compiles with `.\gradlew.bat :app:compileDebugKotlin`.

## OwnerClients State

`OwnerClients` is the first screen being brought into the architecture.

Important files:

- `data/Client.kt`
- `views/state/OwnerClientsUiState.kt`
- `viewmodels/OwnerClientsViewModel.kt`
- `views/screens/OwnerClients.kt`

The intended pattern:

- `Client` is only data. It must not import Compose or ViewModel APIs.
- `OwnerClientsUiState` stores base state such as `query`, `clientes`, `isLoading`, and `errorMessage`.
- Derived values such as filtered clients should be calculated with custom getters.
- `OwnerClientsViewModel` owns the `MutableStateFlow`, loads temporary clients, and updates `query`.
- `OwnerClients` observes `uiState`, renders content, and sends user actions to the ViewModel.

When explaining this screen, emphasize the difference between:

- state that is stored
- state that is derived
- events sent from UI to ViewModel

## Near-Term Next Steps

Recommended continuation order:

1. Verify the current navigation build.
2. Clean `NavBar.kt` imports if any old navigation imports remain.
3. Test the five bottom tabs on device.
4. Add simple Logcat debugging for route changes if needed.
5. After navigation works, consider separating screens into `Root` and `Screen` composables.
6. Move temporary client demo data out of the ViewModel into a fake repository later.

Do not start repository refactors before the basic navigation is verified.

## Verification Commands

Use:

```powershell
.\gradlew.bat :app:compileDebugKotlin
```

If needed, use Android Studio Run to install on the connected phone. Source files are not copied manually; Android Studio builds and installs the APK.

