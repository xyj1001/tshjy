
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectedDate: '', // 保存选择的日期
    selectedNumber: '', // 保存选择的编号
    numberList: ['花盆1', '花盆2', '花盆3', '花盆4'], // 编号的选项列表
    data_list:{
      "code": 200,
      "msg": "success",
      "data": [
          {
              "id": 1,
              "airTemper": 20.01,
              "airHum": 73.021,
              "airQur": 30.931,
              "lightInt": 108.2134,
              "soilMoi": 23.441,
              "soilPh": 6.43,
              "recordTime": "2023-11-20T07:57:47"
          },
          {
              "id": 2,
              "airTemper": 20.01,
              "airHum": 73.021,
              "airQur": 30.931,
              "lightInt": 108.2134,
              "soilMoi": 23.441,
              "soilPh": 6.43,
              "recordTime": "2023-11-20T07:57:47"
          },
          {
              "id": 3,
              "airTemper": 20.01,
              "airHum": 73.021,
              "airQur": 30.931,
              "lightInt": 108.2134,
              "soilMoi": 23.441,
              "soilPh": 6.43,
              "recordTime": "2023-11-21T07:57:47"
          }
      ]
  },
   
 
  },
  bindDateChange: function(e) {
    this.setData({
      selectedDate: e.detail.value
    })
  },
  bindNumberChange: function(e) {
    this.setData({
      selectedNumber: this.data.numberList[e.detail.value]
    })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    // 在页面加载时发送请求
    this.getRecordsData();
  },
  getRecordsData: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/getRecords', // 请求的URL
      method: 'GET',
      success: function (res) {
        // 请求成功，将数据保存在data_list中
        that.setData({
          data_list: res.data
        });
      },
      fail: function (err) {
        // 请求失败
        console.log(err);
      }
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {
     
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {
this.onLoad()
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})