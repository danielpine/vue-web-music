<h1 align="center">web-music</h1>

实现的主要模块和功能如下

1.用户管理模块:用户登录、用户注册、修改密码,歌手管理,歌曲管理(增删查),歌单管理等功能

2.榜单,歌手列表模块:动态地从数据库中获取歌曲的链接和数据在榜单中显示

3.歌曲搜索模块:在页的搜索框中可以输入关键字进行歌曲的模搜索

4.歌曲评论,收藏模块:实现对歌曲的评论。在榜单列表中或搜索页面中可以点击歌曲进行收藏

5.我的音乐模块:收藏的歌曲会被添加到我的音乐列表中，在我的音乐列表中也可以对歌曲进行删除操作

6.音乐播放模块:在榜单搜索页面和我的音乐列表等地方点击歌曲可以跳转到播放页面进行播放。
  播放页面显示播放进度条，删除歌曲，暂停，下载歌曲等操作。
  播放页面背景为模糊背景，根据歌手的专辑图片自动变化。调节音量等操作。

7.个性化推荐模块实现:基于用户和音乐的标签算法。

1) 获取音乐标签:根据歌曲类型和用户收藏的歌曲作为标签，分析内容并生成标签。
2) 将用户与标签、音乐与标签进行关联:统计每个用户最常用标签;对于每个标签，统计被打过这个标签次数最多的音乐。
3) 计算用户对物品的兴趣度本质上是对于一个用户找到他最常用的标签，从而找到具有这些标签的高匹配度音乐进行推荐。
4) 生成个性化的音乐推荐列表。

<br/>

## 音乐类型

### 专区
	DJ专区 儿歌 抖音专区 影视专区 古风专区 网红专区 综艺专区 轻音乐专区 二次元专区 佛乐专区
	新歌首发专区 铃声专区 日韩专区 说唱专区
### 主题
	翻唱 网络 经典 轻音乐 怀旧 古风 网红 佛乐 影视 器乐 游戏 二次元 KTV 喊麦 抖音 3D 店铺专用 纯音乐 小说
### 专区
	伤感 放松 励志 开心 甜蜜 兴奋 安静 治愈 寂寞 思念

## 项目说明

本音乐网站的开发主要利用 VUE 框架开发前台和后台，后端接口用 Spring Boot + MyBatis 来实现，数据库使用的是 MySQL。实现思路可以看[这里](https://yin-hongwei.github.io/2019/03/04/music/#more)。

<br/>

## 项目截图

> 前台截图预览

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec0a2vd9j31c00u0n4z.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec0qtdxrj31c00u07wj.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec19x0e6j31c00u0npe.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec1nmbt4j31c00u0hcf.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec1yc0gkj31c00u0kjm.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec29vvdtj31c00u0nok.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec2ixqk1j31c00u0qf8.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec31i06gj31c00u0wtw.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec3ozxt9j31c00u0qbv.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1geec41r7onj31c00u047y.jpg)<br/>

> 后台截图预览

![](https://tva1.sinaimg.cn/large/006tNbRwly1g9hhhu4n7tj31c00u04qq.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1ghrnrvgflvj31c00u0jzh.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1ghrns4ycpkj31c00u0qjl.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1ghrnsfearcj31c00u0axt.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1ghrnsq6s3sj31c00u0tmu.jpg)<br/>

![](https://tva1.sinaimg.cn/large/007S8ZIlly1ghrnszq403j31c00u07nq.jpg)<br/>

## 功能

- 音乐播放
- 用户登录注册
- 用户信息编辑、头像修改
- 歌曲、歌单搜索
- 歌单打分
- 歌单、歌曲评论
- 歌单列表、歌手列表分页显示
- 歌词同步显示
- 音乐收藏、下载、拖动控制、音量控制
- 后台对用户、歌曲、歌手、歌单信息的管理

<br/>

## 技术栈

#### 后端

SpringBoot + MyBatis

#### 前端

Vue + Vue-Router + Vuex + Axios +  ElementUI

<br/>

## 安装

#### 1、下载项目到本地

```
git clone https://github.com/Yin-Hongwei/music-website.git
```

#### 2、下载数据库中记录的资源

去【链接: https://pan.baidu.com/s/1Qv0ohAIPeTthPK_CDwpfWg 提取码: gwa4 】下载网站依赖的歌曲及图片，将 data 夹里的文件直接放到 music-server 文件夹下。

<img src="https://tva1.sinaimg.cn/large/007S8ZIlly1gekwp2wqxuj311v0u0du2.jpg" height="200px"/>

#### 3、修改配置文件
1）创建数据库
将 `music-website/music-server/sql` 文件夹中的 tp_music.sql 文件导入数据库。

2）修改后端配置文件
去 `music-website/music-server/src/main/resources` 这个目录下的文件里修改自己的 spring.datasource.username 和 spring.datasource.password；
修改下图圈出来的的文件中 MyPicConfig 类下的 addResourceLocations方法中的路径，否则资源加载不了。（Mac 和 win 下路径有些差异，我的是 Mac 上的路径，win 上需要在 file: 后标明是哪个盘，例如：`file:C:\\user\\XXX\\`）

![](https://tva1.sinaimg.cn/large/00831rSTly1gd38cq6yhrj31zk0juk02.jpg)

#### 4、启动项目

music-server 是本项目的后端，用于监听前端发来的请求，提供响应。music-client 和 music-manage 都是本项目的前端部分，前者是前台，后者是后台。运行时后端必须启动，两个前端项目可以都启动，也可以只启动其中一个，他们是独立的。

- **启动后端**：进入 music-server 文件夹，运行下面命令启动服务器

```js
// 方法一
./mvnw spring-boot:run

// 方法二
mvn spring-boot:run // 前提装了 maven
```

- **启动前台**：进入 music-client 文件夹，运行下面命令启动前台项目

```js
npm install // 安装依赖

npm run dev // 启动前台项目
```

- **启动后台**：进入 music-manage 文件夹，运行下面命令启动后台管理项目

```js
npm install // 安装依赖

npm run dev // 启动后台管理项目
```

<br/>

## License

Copyright (c) 2021 web-music 

