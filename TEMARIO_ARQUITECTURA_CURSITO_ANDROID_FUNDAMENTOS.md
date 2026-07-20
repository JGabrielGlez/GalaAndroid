# Temario de estudio — arquitectura de CursitoAndroidFundamentos

> Alcance: temario de investigación para examen. No es una guía de implementación ni contiene las respuestas desarrolladas. Se elaboró a partir del código actual del proyecto `CursitoAndroidFundamentos` y de su documentación interna.

## 0. Mapa del modelo que debes poder reconocer

- Aplicación Android de **un módulo `:app`**, organizada **por feature** (`auth`, `contactos`, `chat`, `perfil`, `onboarding`) y por responsabilidad dentro de cada feature.
- Arquitectura principal: **MVVM + UDF**, con elementos pragmáticos de **Clean Architecture**.
- Capas presentes: `presentation`, `domain`, `data` y `core` transversal.
- Patrón de pantalla: **`UiState` + `Actions` + `Screen` + `Root` + `ViewModel`**.
- Dependencias: **DI manual** con `Application` → `AppContainer` → contenedores por feature → `ViewModelProvider.Factory`.
- Datos: contratos de repositorio en dominio, implementaciones Firebase/locales en datos, DTOs y mappers.
- UI: Jetpack Compose declarativo, Material 3, tema propio y componentes reutilizables.
- Navegación: Navigation Compose con rutas type-safe serializables y grafos por feature.
- Asincronía: corrutinas, `StateFlow`, `Flow`, `callbackFlow` y conversión de `Task` de Firebase con `await()`.

---

## 1. Arquitectura Android y organización del proyecto

- [ ] Arquitectura por capas: responsabilidades de `presentation`, `domain`, `data` y `core`.
- [ ] Organización **feature-first** frente a organización puramente por capas globales.
- [ ] Dependencias permitidas entre capas y regla de inversión de dependencias.
- [ ] Diferencia entre modelo de dominio, DTO/documento remoto y modelo de UI.
- [ ] Conceptos de fuente única de verdad y repositorio como frontera de datos.
- [ ] Por qué el proyecto es Clean Architecture **pragmática** y no una implementación estricta.
- [ ] Razón de existir de los casos de uso, aun cuando algunos delegan directamente al repositorio.
- [ ] Responsabilidades y límites de `core`: utilidades, red, DI, datos transversales, seguridad, UI y notificaciones.
- [ ] Concepto de *composition root* y por qué `AppContainer` es el punto de ensamblaje.
- [ ] Ventajas y límites de mantener todo en un solo módulo Gradle.

### Preguntas de repaso

- [ ] Poder dibujar el flujo: `Screen → Actions → ViewModel → UseCase → Repository (interfaz) → implementación data` y el retorno hacia el `UiState`.
- [ ] Poder explicar qué se rompería si un composable consumiera Firestore directamente.
- [ ] Poder ubicar una nueva clase (por ejemplo, DTO, caso de uso, estado o componente) en su paquete correcto.

## 2. MVVM aplicado con Jetpack Compose

- [ ] Roles de **Model, View y ViewModel** en Android moderno.
- [ ] `ViewModel`: ciclo de vida, conservación ante recreación de Activity y por qué no debe conocer composables ni `NavController`.
- [ ] Patrón de un ViewModel por pantalla/caso de presentación.
- [ ] Estado privado mutable y estado público de solo lectura: `MutableStateFlow` + `asStateFlow()`.
- [ ] `viewModelScope` para operaciones asíncronas y cancelación asociada al ViewModel.
- [ ] Actualización inmutable del estado con `copy()` y `StateFlow.update`.
- [ ] Estados de carga, éxito, error y vacío.
- [ ] Diferencia entre validación de formulario, error de campo y error de operación remota.
- [ ] Estado derivado en UI: filtrado de contactos y banderas como `mostrarLista`.
- [ ] Cuándo usar un `data class UiState` y cuándo un `sealed interface UiState`.
- [ ] `data object`, `data class` y exhaustividad del `when` con estados sellados.

### Caso canónico a estudiar

- [ ] Seguir completo el flujo de `ListaContactoUiState`, `ListaContactoViewModel`, `ListaContactoRoot` y `ListaContactoScreen`.
- [ ] Comparar ese estado sellado con el `LoginUiState` basado en `data class`.
- [ ] Estudiar el ViewModel de chat como ejemplo de estado que se actualiza desde un `Flow` continuo.

## 3. UDF (Unidirectional Data Flow) y gestión de estado

- [ ] Definición de UDF y dirección del flujo: estado hacia abajo, eventos hacia arriba.
- [ ] Diferencia entre **estado**, **evento de usuario**, **acción/callback** y **efecto de una sola vez**.
- [ ] Inmutabilidad y previsibilidad del estado.
- [ ] *State hoisting*: `value` + callback de cambio en campos y componentes reutilizables.
- [ ] Estado de negocio en ViewModel vs. estado visual local con `remember`.
- [ ] `remember`, claves de `remember` y cuándo evitar guardar datos de negocio en el composable.
- [ ] `LaunchedEffect(Unit)`: carga inicial y riesgos de relanzar efectos por recomposición.
- [ ] Protección contra acciones repetidas causada por recomposición (ejemplo: decisión del splash).
- [ ] Uso de `remember(viewModel)` para agrupar `Actions` estables.
- [ ] Efectos transitorios: navegación, snackbar y el problema de representarlos como estado persistente.
- [ ] Alternativas para efectos one-shot: callbacks, `Channel`, `SharedFlow`; identificar cuál usa el código actual y cuál documenta como evolución.

## 4. Separación Root / Screen / Actions / UiState

- [ ] Qué significa composable **stateless** y composable **stateful**.
- [ ] Responsabilidad de `Screen`: renderizar solamente `UiState` y emitir callbacks de `Actions`.
- [ ] Responsabilidad de `Root`: obtener el ViewModel, recolectar estado con ciclo de vida, conectar callbacks y ejecutar efectos de entrada.
- [ ] Responsabilidad de `AppHost`: declarar y conectar navegación, no cargar datos ni construir UI de negocio.
- [ ] Objeto `Actions` como agrupador de eventos de una pantalla.
- [ ] Por qué esta separación permite previews y pruebas más sencillas.
- [ ] `PreviewParameterProvider` y representación de todos los estados visuales.
- [ ] Reglas de acoplamiento: qué conocen y qué no conocen AppHost, Root, Screen y ViewModel.

## 5. Kotlin imprescindible para este modelo

- [ ] Sintaxis y semántica de `data class`, `object`, `data object`, `enum class` y `sealed class/interface`.
- [ ] Clases, interfaces, visibilidad y encapsulamiento con `private`.
- [ ] Constructor primario e inyección por constructor.
- [ ] Funciones `suspend` y `operator fun invoke()` en casos de uso.
- [ ] Lambdas, tipos de función, callbacks y referencias a métodos.
- [ ] Funciones de extensión: mappers `toContacto`, `toDocument`, `toMessage` y helpers de navegación.
- [ ] Null safety: `?`, `?:`, `?.`, `!!` (por qué evitarlo), `orEmpty`, `mapNotNull` y retornos tempranos.
- [ ] Colecciones y transformaciones: `map`, `filter`, `sorted`, `sortedWith`, `firstOrNull`, `associate` cuando aplique.
- [ ] Inmutabilidad de `val`, `copy()` y colecciones de lectura.
- [ ] Genéricos y covarianza: `Result<out T>`.
- [ ] `when` exhaustivo sobre tipos sellados.
- [ ] `by lazy`, propiedades calculadas (`get()`) y `companion object`.
- [ ] Anotaciones relevantes: `@Composable`, `@Serializable`, `@Preview`, `@OptIn`.

## 6. Corrutinas y Flow

- [ ] Qué problema resuelven las corrutinas en Android.
- [ ] `suspend`, `launch`, `viewModelScope` y propagación/cancelación.
- [ ] `StateFlow`: estado caliente, valor inicial y consumo en UI.
- [ ] Diferencia entre `StateFlow`, `Flow`, `SharedFlow` y `Channel`.
- [ ] `collect` de flujos en el ViewModel.
- [ ] `collectAsStateWithLifecycle`: integración Flow–Compose respetando el ciclo de vida.
- [ ] `callbackFlow` y `awaitClose`: adaptar listeners de Firebase a `Flow` y liberar el listener.
- [ ] `kotlinx-coroutines-play-services`: transformar `Task` de Firebase a suspensión mediante `await()`.
- [ ] Manejo correcto de `CancellationException`: por qué debe relanzarse y no traducirse a error de UI.
- [ ] Operaciones optimistas o de respuesta inmediata (por ejemplo, limpiar el input del chat antes del resultado).

## 7. Capa domain: modelos, contratos y casos de uso

- [ ] Entidades de dominio: `Contacto`, `Usuario`, `Chat`, `Mensaje` y sus invariantes.
- [ ] Interfaces de repositorio como contratos independientes de Firebase.
- [ ] Operaciones CRUD y firmas `suspend`.
- [ ] Repositorios que exponen `Flow` para datos en tiempo real.
- [ ] Casos de uso por operación: obtener, agregar, actualizar, eliminar, autenticar, observar, enviar y marcar leídos.
- [ ] Beneficios y costo de un caso de uso que solo delega.
- [ ] Composición entre features desde casos de uso (detalle de contacto → perfil/chat) y límites de acoplamiento.
- [ ] Preferencias como contrato de dominio (`UserPreferences`, `OnboardingPreferences`).

## 8. Capa data: repositorios, Firebase, DTOs y mappers

- [ ] Patrón Repository: interfaz en dominio e implementación concreta en datos.
- [ ] Firebase Authentication: registro, inicio/cierre de sesión, `currentUser` y actualización de perfil.
- [ ] Cloud Firestore: colecciones, documentos, consultas, ordenamientos, `set`, `add`, `update`, `delete` y `SetOptions.merge()`.
- [ ] Control de propietario (`owner`) y lectura/escritura asociadas al usuario autenticado.
- [ ] Listeners de snapshots de Firestore para lista de chats y mensajes en tiempo real.
- [ ] Identificador determinista de conversación a partir de UIDs ordenados.
- [ ] Batch writes para marcar mensajes como leídos.
- [ ] DTO/documento de Firestore y requisitos de constructores/valores por defecto para deserialización.
- [ ] Mapeadores DTO ↔ dominio y por qué la UI no debe recibir DTOs.
- [ ] Repositorio fake/local frente a repositorio remoto y sustituibilidad por contrato.
- [ ] Persistencia local con `SharedPreferences` y abstracción mediante interfaces.
- [ ] Cifrado de campos sensibles con `AesCipher`: ubicación correcta del cifrado en el boundary de datos.

## 9. Resultado y manejo de errores

- [ ] Resultado tipado con `sealed class Result<out T>`: `Success` y `Error`.
- [ ] Función genérica `ejecutar` como envoltura de excepciones.
- [ ] Traducción de excepciones técnicas a mensajes de dominio/presentación con una extensión de `Throwable`.
- [ ] Errores de Firebase Auth, Firestore, red, timeout y credenciales.
- [ ] Qué errores se muestran al usuario y qué información no debe filtrarse.
- [ ] Diferencia entre error recuperable, ausencia de datos y cancelación de corrutina.
- [ ] Manejo de error en cada ViewModel sin perder estado útil cuando corresponde.

## 10. Jetpack Compose

- [ ] Paradigma declarativo: la UI como función del estado.
- [ ] Recomposición: qué la dispara, por qué debe ser idempotente y errores comunes.
- [ ] Funciones `@Composable`, parámetros por defecto y `Modifier` como cadena de decoración.
- [ ] Layouts y componentes utilizados: `Scaffold`, `Column`, `Box`, `LazyColumn`, `items`, FAB, top app bar y bottom bar.
- [ ] Material 3: `MaterialTheme`, `colorScheme`, tipografía, `SnackbarHost`, diálogos e indicadores de carga.
- [ ] Listas perezosas, claves estables de items y rendering de estados vacío/carga/error/éxito.
- [ ] Formularios controlados, campos de texto y validación mostrada desde `UiState`.
- [ ] Componentización y reutilización en `core/ui/components`.
- [ ] Previews, datos de preview y por qué una Screen sin ViewModel es previsualizable.
- [ ] Tema Compose: `Color`, `Type`, `Spacing`, fuentes locales y modo oscuro.
- [ ] Edge-to-edge, `statusBarsPadding` y `navigationBarsPadding`.
- [ ] Accesibilidad en Compose: `contentDescription`, semántica, tamaños táctiles y contraste.

## 11. Navigation Compose

- [ ] `NavController`, `NavHost`, `NavGraphBuilder` y destinos `composable`.
- [ ] Grafos por feature y composición de grafos en `AppHost`.
- [ ] Rutas type-safe con `@Serializable`, `object` y `data class`.
- [ ] Envío de argumentos de ruta y lectura con `toRoute<T>()`.
- [ ] Navegar solo con identificadores/argumentos mínimos; recuperar el resto desde la capa de datos.
- [ ] `navigateUp`, `popUpTo`, `inclusive`, `findStartDestination` y limpieza del back stack.
- [ ] Navegación de tabs con `saveState`, `restoreState` y `launchSingleTop`.
- [ ] Diferencia entre navegación de tab, navegación hacia detalle y navegación posterior a login/splash.
- [ ] Separación entre callbacks de navegación de los Roots y la lógica de datos del ViewModel.
- [ ] `SavedStateHandle` y argumentos de navegación: estudiarlo como extensión documentada del patrón, aunque el código actual pasa algunos IDs desde el graph al Root.

## 12. Inyección de dependencias manual

- [ ] Problema que resuelve DI: construcción, reemplazo y compartición de dependencias.
- [ ] `Application` como dueño de objetos de vida de proceso.
- [ ] `AppContainer` como contrato y `DefaultAppContainer` como implementación.
- [ ] Instanciación perezosa con `by lazy` y alcance de singleton por proceso.
- [ ] Contenedores por feature: `AuthContainer`, `ContactosContainer`, `ChatContainer`, `PerfilContainer`, `OnboardingContainer`.
- [ ] `ViewModelProvider.Factory`, `viewModelFactory` e `initializer`.
- [ ] Recuperación del contenedor desde Compose con `LocalContext` y `applicationContext`.
- [ ] Dependencias por constructor y test doubles/fakes.
- [ ] Factories que dependen de argumentos de ruta (caso del chat).
- [ ] Cuándo este patrón deja de escalar y fundamentos de Hilt/Koin como evolución.

## 13. Android platform, seguridad y servicios

- [ ] Ciclo de vida de `ComponentActivity`, `onCreate` y `onDestroy`.
- [ ] `setContent`, `enableEdgeToEdge` y punto de arranque de Compose.
- [ ] `AndroidManifest`: `Application`, permisos y declaración de servicios.
- [ ] Permisos en tiempo de ejecución; caso `POST_NOTIFICATIONS` para Android 13+.
- [ ] Firebase Cloud Messaging: token, `FirebaseMessagingService`, recepción foreground/background y canales de notificación.
- [ ] Separación entre notificador genérico y notificador específico de chat.
- [ ] Autenticación persistida y decisión de splash/onboarding/login/home.
- [ ] Principios de manejo de secretos, datos personales, cifrado y reglas de Firestore.

## 14. Gradle, build variants y preparación de release

- [ ] Gradle Kotlin DSL: plugins, `android {}`, dependencias y version catalog.
- [ ] Compose compiler/plugin y BOM de Compose/Firebase.
- [ ] `minSdk`, `targetSdk`, `compileSdk`, `namespace` y `applicationId`.
- [ ] Build types `debug`, `qa` y `release`.
- [ ] `applicationIdSuffix`, `versionNameSuffix`, `BuildConfig` y recursos por variante.
- [ ] URLs/configuración por ambiente y no hardcodear secretos.
- [ ] Firma de release, keystore y separación de credenciales.
- [ ] R8/ProGuard, minificación, shrink de recursos y reflexión de Firebase/serialización.
- [ ] Verificación de APK release en dispositivo y diferencias runtime entre debug/release.
- [ ] Logging condicionado por `BuildConfig.DEBUG`.

## 15. Patrones de diseño identificables

- [ ] **MVVM**: View, ViewModel y modelo/estado.
- [ ] **Repository**: contrato de datos y fuentes intercambiables.
- [ ] **Use Case / Interactor**: encapsulación de una acción de negocio.
- [ ] **Dependency Injection** y **Composition Root**: construcción externa de dependencias.
- [ ] **Factory**: creación de ViewModels con dependencias/argumentos.
- [ ] **Adapter**: `callbackFlow` adapta listeners de Firebase a `Flow`.
- [ ] **Mapper / Data Mapper**: conversión Firestore document ↔ dominio.
- [ ] **Facade**: repositorios que simplifican APIs de Firebase para el dominio.
- [ ] **Strategy / implementación intercambiable**: repositorios fake, local y Firebase detrás de interfaces.
- [ ] **Observer / Reactive streams**: `Flow`, `StateFlow` y listeners de Firestore.
- [ ] **Singleton de alcance de aplicación**: dependencias `by lazy` en el container; diferenciarlo de un singleton global arbitrario.

## 16. Arquitecturas a comparar para el examen

- [ ] MVVM + UDF: características, ventajas, riesgos y ajuste con Compose.
- [ ] MVI: intents, reducer, estado y effects; diferencias de boilerplate y trazabilidad frente a MVVM.
- [ ] Clean Architecture estricta: reglas de dependencia, independencia de framework y costo de capas.
- [ ] MVP: por qué encaja peor con UI declarativa de Compose.
- [ ] Redux/store global: fuente única global, beneficios y acoplamiento potencial.
- [ ] Criterios para elegir arquitectura según tamaño, complejidad, equipo y necesidades de pruebas.

## 17. Pruebas y calidad (base que debes investigar)

- [ ] Pirámide de pruebas Android: unitarias, instrumentadas y UI tests de Compose.
- [ ] Pruebas de ViewModel con fakes de repositorio, coroutines test y aserciones de `UiState`.
- [ ] Pruebas de casos de uso y mappers.
- [ ] Pruebas de composables stateless por estado: loading, error, vacío y éxito.
- [ ] Pruebas de navegación y argumentos de rutas type-safe.
- [ ] Pruebas de repositorios Firebase: qué aislar y qué cubrir con integración.
- [ ] Calidad estática: convenciones, nombres, responsabilidades pequeñas y evitar acoplamiento a Android en dominio.
- [ ] Diagnóstico con Logcat sin exponer información sensible.

## 18. Orden recomendado de estudio

1. [ ] Kotlin: tipos sellados, `data class`, lambdas, null safety, extensiones, colecciones y corrutinas.
2. [ ] Compose básico: estado, recomposición, `remember`, state hoisting, layouts y Material 3.
3. [ ] MVVM y UDF: `UiState`, `Actions`, `ViewModel`, `StateFlow` y `collectAsStateWithLifecycle`.
4. [ ] Patrón Root/Screen y previews; recorrer la feature `contactos` de punta a punta.
5. [ ] Domain/data: repositorios, casos de uso, `Result`, DTOs y mappers.
6. [ ] Navigation Compose: rutas type-safe, grafos por feature, argumentos y back stack.
7. [ ] DI manual: Application, AppContainer, factories y alcance de dependencias.
8. [ ] Firebase/Auth/Firestore y `callbackFlow` para tiempo real.
9. [ ] Persistencia local, seguridad/cifrado, notificaciones FCM y permisos.
10. [ ] Gradle, ambientes, release, R8 y comparación MVVM–MVI–Clean–MVP–Redux.

## 19. Recorrido de archivos para estudiar el código real

1. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/MainActivity.kt`
2. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/AppHost.kt`
3. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/core/di/AppContainer.kt`
4. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/contactos/presentation/listaContacto/`
5. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/contactos/domain/`
6. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/contactos/data/remote/`
7. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/contactos/presentation/navigation/`
8. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/auth/`
9. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/feature/chat/`
10. [ ] `app/src/main/java/com/yaeldev/cursitodefundamentosandroid/core/network/`, `core/data/`, `core/notifications/` y `core/security/`
11. [ ] `app/build.gradle.kts`, `gradle/libs.versions.toml` y `docs/Preparacion-Produccion-Ambientes.md`

## 20. Checklist final de autoevaluación

- [ ] Puedo explicar la arquitectura sin confundir feature, capa y patrón.
- [ ] Puedo seguir un click desde un composable hasta Firestore y de regreso al estado que pinta la UI.
- [ ] Puedo justificar por qué `Screen` no recibe un repositorio ni un `NavController`.
- [ ] Puedo explicar por qué el ViewModel expone `StateFlow` inmutable al exterior.
- [ ] Puedo diferenciar `StateFlow`, `Flow`, evento one-shot y estado local de Compose.
- [ ] Puedo explicar cómo se inyecta un repositorio hasta un ViewModel sin Hilt.
- [ ] Puedo explicar las rutas type-safe, argumentos y limpieza de back stack.
- [ ] Puedo justificar DTOs/mappers y contratos de repositorio frente a usar Firebase en UI.
- [ ] Puedo describir cómo se traducen errores técnicos a estados de presentación.
- [ ] Puedo comparar la decisión MVVM + UDF con MVI, Clean, MVP y Redux.
