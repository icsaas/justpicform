module.exports = {
    title: 'justpicform使用文档',
    description: 'justpicform使用介绍',
    base: '/', // 项目根路径
    dest: '/dist/', // 打包后的文件夹路径，为了方便，我把 dist 文件夹放到了根目录上
    // head 标签中的额外内容
    head: [
        ['link', {rel: 'icon', href: '/favicon.ico'}] // 这个是标签页 logo
    ],
    themeConfig: {
        // 添加导航栏
        nav: [
            {text:'指南',link:'/guide/install'},
            {text: 'vue', link: '/'},
            {text: 'css', link: '/blog/'},
            {text: 'js', link: '/zhihu/'},
            {
                text: 'github',
                // 这里是下拉列表展现形式。
                items: [
                    {text: 'focus-outside', link: 'https://github.com/TaoXuSheng/focus-outside'},
                    {text: 'stylus-converter', link: 'https://github.com/TaoXuSheng/stylus-converter'},
                ]
            }
        ],
        // 为以下路由添加侧边栏
        sidebar:[
            {
                title:'开发指南',
                collapsable:false,
            },
            ['./guide/install','安装'],
            ['./guide/started','快速上手'],
            {
                title:'组件',
                collapsable: false
            },
            ['./guide/icon','icon']
        ]
    },
    // 语言配置
    locales: {
        // 键名是该语言所属的子路径
        // 作为特例，默认语言可以使用 '/' 作为其路径。
        '/': {
            lang: 'zh-CN', // 将会被设置为 <html> 的 lang 属性
        }
    }
}