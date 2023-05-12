# Music App KMP
This project demonstrate the Online Music Streaming wuth **Compose Multiplatform**, if you want to quickly see Preview [Click Here](https://github.com/swap-musale/Music-App-KMP/assets/125433713/b9ea0234-aee4-45a3-a564-04b417b54db5)

| Platforms | ![](https://img.shields.io/badge/Android-black.svg?style=for-the-badge&logo=android) ![](https://img.shields.io/badge/iOS-black.svg?style=for-the-badge&logo=apple) ![](https://img.shields.io/badge/-Desktop-black?style=for-the-badge&logo=desktop)  |
|-----------|---|


### Screenshots :
### 1. Android App

<table style="width:100%">
  <tr>
    <th>Movie List Screen</th>
  </tr>
  <tr>
    <td><img src = "https://github.com/swap-musale/Music-App-KMP/assets/125433713/08b185c9-6007-466c-a8d6-5f005b5b2ad2" width=250/></td> 
  </tr>
</table>

### 2. iOS App

<table style="width:100%">
  <tr>
    <th>Movie List Screen</th>
  </tr>
  <tr>
    <td><img src = "https://github.com/swap-musale/Music-App-KMP/assets/125433713/0031dc95-5758-4fbf-8118-f41795c87583" width=250/></td> 
  </tr>
</table>

### 3. Desktop App

<table style="width:100%">
  <tr>
    <th>Movie List Screen</th>
  </tr>
  <tr>
    <td><img src = "https://github.com/swap-musale/Music-App-KMP/assets/125433713/31d22233-f6de-475c-b4ee-c8b6f61ae0df" width=450/></td> 
  </tr>
</table>


## 🏗️️ Built with ❤️ using Jetpack Compose 😁

| What            | How                        |
|----------------	|------------------------------	|
| 🎭 User Interface (Android)   | [Jetpack Compose](https://developer.android.com/jetpack/compose)                |
| 🏗 Architecture    | [Clean](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)                            |
| 💉 DI (Android)                | [Koin]()                        |
| 🎵 Audio Player            | [MediaPlayer](https://developer.android.com/guide/topics/media/mediaplayer) + [AVPlayer](https://developer.apple.com/documentation/avfoundation/avplayer/) + [VLC](https://www.videolan.org/vlc/)                |
| 🌐 ViewModel        | [Precompose ViewModel](https://github.com/Tlaster/PreCompose/blob/master/docs/component/view_model.md)                        |
| 🧭 Navigation            | [Precompose Navigation](https://github.com/Tlaster/PreCompose/blob/master/docs/component/navigation.md)                            |
| 🧭 Preference            | [Multiplatform Settings](https://github.com/JetBrains/compose-multiplatform)                            |


## Project structure

This Compose Multiplatform project includes three modules:

### shared
In this module Compose UI code and shared business login stays, which will be later shared with platform according to use case.

### androidApp
In Android module, android platform related code present such as in this case MediaPlayerController.

### iosApp
In ios module, iOS platform related code present such as in this case MediaPlayerController.

### desktopApp
In desktop module, desktop platform related code present such as in this case MediaPlayerController.

## How to run the app
This project use Android Studio Flamingo | 2022.2.1 Patch 1.

Note : To run Desktop app make sure VLC Player is installed on you system as to play Audio files in Desktop app, app uses VLC Lib.

## License
 ```
 Copyright 2023 Swapnil Musale

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```
