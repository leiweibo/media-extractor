import Vue from 'vue'
import { Input, Form, FormItem, Row, Col, Button, Container, Header, Aside, Main, Menu, Submenu, MenuItem, MenuItemGroup, Image, Scrollbar, Loading, Message } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Input)
Vue.use(FormItem)
Vue.use(Form)
Vue.use(Row)
Vue.use(Col)
Vue.use(Button)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Image)
Vue.use(Scrollbar)
Vue.use(Loading)
Vue.use(Message)

Vue.prototype.$loading = Loading.service
Vue.prototype.$message = Message
