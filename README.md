# Student_Manage_System
## 学生信息管理系统
# 一、功能需求
用户登陆学生信息管理系统，如没有可注册。
登陆后，可查看学生的信息，可新增，删除，修改学生；可实现学生成绩管理，如查看成绩，添加成绩等功能。
数据库：学生信息
# 二、需求分析：
## 2.1. 用户登录界面
用户：教师（管理员）权限：对数据库增删改查操作；
   学生权限：查找操作；
（1）登录，输入信息，在数据库中查询成功，跳转主界面（教师界面，学生界面）；
（2）注册，点击注册按钮，跳转注册界面，即在数据库中插入
## 2.2. 注册界面
**注册功能**：
*  需要输入ID, 密码
*  职位：教师/学生，二选1
*  联系方式： 用于修改用户密码
**修改密码功能**：
* 通过ID and 联系方式作为判断条件，
* 修改数据库中改信息的密码
## 2.3. 主界面（结合数据库），实现下述功能
### 2.3.1. 教师（管理员）界面
   作一个下拉列表框，出现下述四个选项，分别打开对应的界面：
（1）增加学生信息或成绩
（2）删除学生信息或成绩
（3）查找学生信息或成绩
（4）修改学生信息或成绩
### 2.3.2 学生界面
做一个下面列表框，出现下述几个成绩查询的功能选项：
（1）查看自己的成绩
（2）查看平均分
（3）查看最高分
（4）查看最低分
# 三、项目详细介绍
## 3.1 注册和修改密码界面
1.注册用户信息(即：在login_info表格中增加数据)
2.修改用户密码(即：根据用户ID and Tel作为查找条件，
 在login_info表格中查找，若查找到，修改密码，若未查找到，给出提示）
 
## 3.2 教师(管理员)界面
权限：
 * 1.增：增加学生信息或成绩；
 * 2.删：根据学生ID and Name ,删除学生信息或成绩
 * 3.改：
          (1)修改某个学生的全部信息(学号除外)；
          (2)修改某个学生的全部成绩(学号除外)；这里的全部信息，是指输入信息不能为空；
 * 4.查：
      (1)查找某个学生信息或成绩
               a.按ID and Name，查找学生信息或成绩,avg,max,min
               b.按Major ,查找同一专业学生信息或成绩,avg,max,min
                c.按Class,查找同一班级学生信息或成绩,avg,max,min
      (2) 查找全部学生信息或成绩
 

## 3.3学生界面
权限：
 * 1、查找某学生成绩或信息
 * 2、查找学生成绩表中的平均分
 * 3、查找学生成绩表中的最高分
 * 4、查找学生成绩表中的最低分

