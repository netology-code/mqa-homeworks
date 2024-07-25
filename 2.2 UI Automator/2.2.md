# Домашнее задание к занятию «2.2. UI Automator. Автоматизация тестирования Android»

Возьмите за основу [лекционный проект](sample) и дополните решениями заданий.

## Задание «UI Automator»

На лекции был реализован один тест на модельное приложение. 

Ваша задача — добавить ещё два теста:
- тест на попытку установки пустой строки;
- тест на открытие текста в новой Activity.

**Первый тест** должен устанавливать в поле ввода пустой текст и осуществлять нажатие на кнопку изменения текста. После нужно проверить, что текст в TextView остался прежним.

Обратите внимание, что пустым также является текст, состоящий только из пробельных символов.

**Второй тест** должен устанавливать в поле ввода непустой текст и осуществлять нажатие на кнопку запуска новой Activity. Затем он должен дождаться появления Activity на экране и в качестве результата сравнить содержимое TextView с текстом, который был установлен в поле ввода.

Для определения ID у TextView, принадлежащего второй Activity, рекомендуем использовать инструмент UI Automator Viewer.

## Задание «GitHub Actions»

После выполнения первой задачи добавьте полученный код в репозиторий на GitHub. Второй задачей будет настройка инструмента GitHub Actions для этого репозитория.

Подробную инструкцию по настройке смотрите ниже.

<details>
<summary>Инструкция для GitHub Actions.</summary>
  
  В вашем репозитории перейдите на вкладку Actions и нажмите на кнопку «Set up this workflow».
  
  ![](pic/actions.png)
  
  Появится окно добавления скрипта GitHub Actions в репозиторий. Имя этого скрипта можете сделать любым, главное — это его расширение, `.yml`.
  Содержимое файла замените скриптом:
  
```yaml
name: Android CI

on:
  push:
    branches: '*'
  pull_request:
    branches: '*'

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'adopt'
        cache: gradle

    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
    
    - name: Build with Gradle
      run: ./gradlew build
      
  test:
    runs-on: macos-13
    steps:
    - uses: actions/checkout@v3
    - name: set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'adopt'
        cache: gradle

    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
      
    - name: run tests
      uses: reactivecircus/android-emulator-runner@v2
      with:
        api-level: 29
        script: ./gradlew connectedCheck
```
  
Скрипт сначала проверяет сборку вашего проекта через команду `./gradlew build`, а затем запускает виртуальную машину с macOS. На ней сначала запускается эмулятор Android, а затем выполняется запуск тестов UI Autimator. Это происходит с помощью специального плагина `android-emulator-runner`.
  
Теперь после каждого коммита в репозиторий будет автоматически запускаться скрипт GitHub Actions, который автоматически будет проверять сборку проекта и корректность выполнения тестов.
</details>

После настройки дождитесь результата запуска тестов и убедитесь, что запуск был успешным.

В качестве результата пришлите ссылки на ваш GitHub-проект с реализованным первым заданием и настроенными GitHub Actions в личном кабинете студента на сайте [netology.ru](https://netology.ru).

Любые вопросы по решению задач задавайте в чате учебной группы.
