[toc]

# 图书管理信息系统

## 1. 项目目录详解

bin：生成的`.class`文件

lib：JDBC依赖的Jar包

src：编写的代码逻辑

UI.java：选择角色（图书管理员、借书者）界面

* ManagerLoginUI.java：图书管理员登录界面
  * ManagerMenu.java：图书管理员功能菜单
    * AddBookInformation.java：增加图书信息至数据库中
    * DeleteBookInformation.java：从数据库中删除一本图书信息
    * ModifyBookInformation.java：修改图书信息
* UserLoginUI.java：借书者登录界面
  * UserMenu.java：借书者功能菜单
    * BorrowBook.java：借书逻辑
    * ReturnBook.java：归还图书逻辑
* ShowBookInformation.java：展示所有可借阅书籍信息



## 2. 业务流程图

### 2.1 借书人员业务流程图

![image-20210807150745511](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150745511.png)

### 2.2 图书管理员业务流程图

![image-20210807150854677](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150854677.png)



## 3. 功能模块图

![image-20210807150942250](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150942250.png)

## 4. UI界面效果展示

* 角色选择界面

<img src="https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150025181.png" alt="image-20210807150025181" style="zoom: 50%;" />

* 登录界面

![](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150354422.png)

![image-20210807150114586](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150114586.png)

* 图书管理员功能菜单

![image-20210807150146073](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150146073.png)

* 借书者功能菜单

![image-20210807150440123](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150440123.png)

* 图书增加界面

![image-20210807150218136](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150218136.png)

* 删除图书界面

![image-20210807150249546](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150249546.png)

* 修改图书信息界面

![image-20210807150307896](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150307896.png)

* 查看所有图书信息界面

![image-20210807150323772](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150323772.png)

* 借阅图书界面

![image-20210807150500373](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150500373.png)

* 归还图书界面

![image-20210807150518210](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807150518210.png)

## 5. 数据库设计

### 5.1 ER图设计

![image-20210807151021826](https://raw.githubusercontent.com/gongruiyang/BlogImage/main/img/image-20210807151021826.png)



### 5.2 表结构设计

* 图书表

```sql
CREATE TABLE `tbbook`  (
  `bookName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `ISBN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookState` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
```

* 借书表

```sql
CREATE TABLE `tbborrow`  (
  `bookName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookISBN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bookAuthor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bookISBN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
```

* 图书管理员表

```sql
CREATE TABLE `tbmanager`  (
  `managerAccount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `managerPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`managerAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
```

* 用户表

```sql
CREATE TABLE `tbuser`  (
  `UserAccount` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`UserAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
```

