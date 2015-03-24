Gradle Checkstyle Tester
========================

Checkstyleのチェック結果をテストする用



タスクの依存関係
--------------
```
...
 |__ test
   |__ check
     |__ testCheckstyle
```

参考
----

[gradleでJUnitのCategoryテストを実行する - 2014年版4](http://mike-neck.hatenadiary.com/entry/2014/07/08/015251)
* checkタスクより後にcheckstyle結果テスト用のタスク（testCheckstyle）を実行するために、checkstyle用のJUnitはCategoryで通常のtestとは別タスクで実行している

