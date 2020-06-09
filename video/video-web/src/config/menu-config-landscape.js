module.exports = [{
  name: '公众号文章视频提取',
  id: 'video-extractor',
  componentName: 'video_extractor'
}, {
  name: '基础',
  id: 'basic',
  sub: [{
    name: 'Layout 布局',
    componentName: 'basic_layout1'
  }, {
    name: 'Container 布局容器',
    componentName: 'basic_container1'
  }]
}, {
  name: 'Form',
  id: 'form',
  sub: [{
    name: 'Radio 单选框',
    componentName: 'form_radio'
  }, {
    name: 'Checkbox 多选框',
    componentName: 'form_checkbox'
  }]
},
{
  name: 'Other',
  id: 'other',
  componentName: 'other_comp'
}
]
