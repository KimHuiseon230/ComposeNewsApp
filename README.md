# 📰 NewsApp - Kotlin & Jetpack Compose! 
- Android 뉴스 앱 프로젝트  
- Jetpack Compose와 Retrofit을 활용한 최신 뉴스 조회 앱입니다.  

## 주요 기능
✅ **최신 뉴스 조회** (NewsAPI 사용)  
✅ **Jetpack Compose UI** 적용  
✅ **ViewModel + StateFlow**를 활용한 상태 관리  
✅ **Retrofit + Coroutine**으로 비동기 네트워크 요청  
✅ **Coil을 활용한 뉴스 이미지 로딩**  

---

## 사용 기술
- **언어:** Kotlin
- **UI:** Jetpack Compose, Material 3
- **비동기 처리:** Coroutine, Flow
- **네트워크 통신:** Retrofit2, OkHttp
- **상태 관리:** ViewModel, StateFlow
- **이미지 로딩:** Coil

---

## 앱 화면  
| 목록 화면  |
|------------|
| <img src="https://github.com/user-attachments/assets/2720d3f8-129c-40a5-890a-b0d16e8c8175" width="300"/> |

---

## 프로젝트 설정 방법

### 1️⃣ **News API 키 추가**
NewsAPI에서 API 키를 발급받고, `NewsApiService.kt` 파일에서 아래 부분을 수정하세요.  

```kotlin
@GET("v2/top-headlines")
suspend fun getTopHeadlines(
    @Query("country") country: String = "us",
    @Query("apiKey") apiKey: String = "YOUR_API_KEY" // 👈 여기에 API 키 입력!
): NewsResponse
