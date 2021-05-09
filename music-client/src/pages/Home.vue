<template>
  <div class="home">
    <!--轮播图-->
    <swiper :swiperList="swiperList" />
    <!--热门歌单-->
    <div class="section">
      <div class="section-title">个性推荐</div>
      <content-list
        :contentList="songList"
        path="song-list-album"
      ></content-list>
    </div>
    <!--热门歌手-->
    <div class="section">
      <div class="section-title">歌 手</div>
      <content-list
        :contentList="singerList"
        path="singer-album"
      ></content-list>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { swiperList } from '../assets/data/swiper'
import Swiper from '../components/Swiper'
import ContentList from '../components/ContentList'
import { getSongList, getRecommendSongList, getAllSinger } from '../api/index'

export default {
  name: 'home',
  components: {
    Swiper,
    ContentList
  },
  data () {
    return {
      swiperList: [], // 轮播图列表
      songList: [], // 歌单列表
      singerList: [] // 歌手列表
    }
  },
  computed: {
    ...mapGetters([
      'id',
      'userId', // 用户ID
      'index', // 列表中的序号
      'loginIn', // 用户是否登录
      'avator' // 用户头像
    ])
  },
  created () {
    this.swiperList = swiperList
    // 获取歌单列表
    this.getSongList()
    // 获取歌手列表
    this.getSingerList()
  },
  methods: {
    getSongList () {
      if (this.loginIn) {
        getRecommendSongList(this.userId)
          .then(res => {
            this.songList = res
          })
          .catch(err => {
            console.log(err)
          })
      } else {
        getSongList()
          .then(res => {
            this.songList = res.sort().slice(0, 20)
          })
          .catch(err => {
            console.log(err)
          })
      }
    },
    getSingerList () {
      getAllSinger()
        .then(res => {
          this.singerList = res.sort().slice(0, 10)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../assets/css/home.scss';
</style>
