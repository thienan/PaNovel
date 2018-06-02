package cc.aoeiuv020.panovel.api.site

import org.junit.Test

/**
 * Created by AoEiuV020 on 2018.05.10-22:13:32.
 */
class QlyxTest : BaseNovelContextText(Qlyx::class) {
    init {
        (context as Qlyx).verify()
    }

    @Test
    fun yunsuo() {

    }

    @Test
    fun search() {
        // http://www.76wx.com/modules/article/search.php%3Fsearchtype=articlename&searchkey=%D0%DE%D5%E6&page=1
        search("都市")
        search("都市大相医", "减肥哥", "11437")
        search("斗破苍穹之万界商城", "梦回夕照", "7395")
        search("恐怖广播", "纯洁滴小龙", "29")
    }

    @Test
    fun detail() {
        detail("454", "454", "修真聊天群", "圣骑士的传说",
                "http://www.76wx.com/files/article/image/0/454/454s.jpg",
                "某天，宋书航意外加入了一个仙侠中二病资深患者的交流群，里面的群友们都以‘道友’相称，群名片都是各种府主、洞主、真人、天师。" +
                        "连群主走失的宠物犬都称为大妖犬离家出走。整天聊的是炼丹、闯秘境、炼功经验啥的。\n" +
                        "突然有一天，潜水良久的他突然发现……群里每一个群员，竟然全部是修真者，能移山倒海、长生千年的那种！\n" +
                        "啊啊啊啊，世界观在一夜间彻底崩碎啦！\n" +
                        "书友群：九洲1号群:207572656\n" +
                        "九洲２号群:168114177\n" +
                        "九洲３号群:165210665（新）\n" +
                        "九洲一号群（VIP书友群，需验证）63769632",
                "2018-05-20 18:55:01")
    }

    @Test
    fun chapters() {
        chapters("454",
                "第一章 黄山真君和九洲一号群", "454/277839", null,
                "第1941章 乱了，彻底乱了", "454/4872801", "2018-05-20 18:55:01",
                1960)
    }

    @Test
    fun content() {
        content("5017/2760870",
                "林远凡“活”了之后的几天一直都躺在重症监护室中，各种进口仪器的感应器布满了他身体，头上打着绷带，骨折的手臂也用夹板固定住了。",
                "“先找个灵气稍微丰富的地方修炼一番，踏入炼气期再说，要是有什么天材地宝就更好了。”" +
                        "想到这林远凡不禁摇了摇头，地球灵气如此稀薄，人类众多，怕是年份稍长一些的药材都被采完了，就算是有也不是现在的自己能弄到手的。",
                58)
    }
}
