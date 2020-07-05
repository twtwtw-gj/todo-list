# To Do リストAPI

To Do リストのAPIサーバーです。

## 開発目的・特徴

* Spring Boot を使用して速やかにRESTサーバーの立ち上げを行う
* Hibernateで自動テーブル作成を使う。  
* etc  

## 環境

* JDK 14
* MySQL 8
* Maven（Intellij IDEAのプラグインで使用）

### ツール、開発環境など  
* GitBash  
* IntelliJ IDEA Community版  ※EclipseでもOK

### 起動方法

以下はIntelliJ IDEAでの操作を解説しています。

1. データベース作成

    今回はhibernateの自動テーブル作成機能を使っているので、テーブル作成する必要はありません。
    ただし、データベースは事前に作成する必要はあります。

    MySQLコマンド上で、下記のコマンドを打ち込んでください。
    ```
    create database to_do_list;
    ```
    to_do_listの中には何もテーブルを入れなくて大丈夫です。

1. パッケージのインストール

    IntelliJ上でなら、Ctrlキーを2度押すとRun Anythingウィンドウが立ち上がります。この上でならMavenのコマンドを使うことが出来ます。

    以下のコマンドを入力してください。
    ```
    mvn install
    ```
    Mavenパッケージのインストール・JUnitのテストが自動的に行われます。

    テストの過程でto_do_listデータベースへの接続を自動的に行います。もしこの段階でデータベースを作成していなかった場合、テストに失敗します。

1. 開発用サーバー起動

    左のサイドバーでsrc/main内のTodoListApplication.javaを右クリックして、「Run TodoListApplication...main()」を選んでください。サーバーが立ち上がります。

1. ブラウジング
    ブラウザ上で以下のURLにアクセスしてください。
    ```
    http://localhost:8080/todo
    ```
    全件が取得され、JSONの形で表示されます。最初は何も入れていないので、空のリストが表示されるはずです。

    上と同じパスでid (Integer), name (String)を入力して、Postリクエストしてください。保存されます。再度ブラウザ上にアクセスすると、取得できます。

    PostのREST APIの作成をする方法は色々あります（コマンドラインを使う・Chromeの拡張機能を使うなど）。
    Postmanというアプリを使用するのがオススメです。

### 注意点

サーバー切断・再接続の際に前のテーブルの削除・再作成をします。その際に、以前の接続で使用していたデータはすべて削除されます。

既存のデータを再利用する場合は、バックアップを取るか、src/main/resources/application.propertiesのspring.jpa.hibernate.ddl-autoプロパティを変更してください。