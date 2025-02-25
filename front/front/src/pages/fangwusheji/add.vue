<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"border":"1px solid #eee","width":"100%","padding":"30px","position":"relative","background":"#fcfcfc"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="180px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="装修公司名称" prop="gongsimingcheng">
            <el-input v-model="ruleForm.gongsimingcheng" 
                placeholder="装修公司名称" clearable :disabled=" false  ||ro.gongsimingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="负责人" prop="fuzeren">
            <el-input v-model="ruleForm.fuzeren" 
                placeholder="负责人" clearable :disabled=" false  ||ro.fuzeren"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="装修公司封面" v-if="type!='cross' || (type=='cross' && !ro.gongsifengmian)" prop="gongsifengmian">
            <file-upload
            tip="点击上传装修公司封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.gongsifengmian?ruleForm.gongsifengmian:''"
            @change="gongsifengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="装修公司封面" prop="gongsifengmian">
                <img v-if="ruleForm.gongsifengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.gongsifengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.gongsifengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="联系方式" prop="lianxifangshi">
            <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" clearable :disabled=" false  ||ro.lianxifangshi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="空间" prop="kongjian">
            <el-input v-model="ruleForm.kongjian" 
                placeholder="空间" clearable :disabled=" false  ||ro.kongjian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="软装" prop="ruanzhuang">
            <el-input v-model="ruleForm.ruanzhuang" 
                placeholder="软装" clearable :disabled=" false  ||ro.ruanzhuang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="硬装" prop="yingzhuang">
            <el-input v-model="ruleForm.yingzhuang" 
                placeholder="硬装" clearable :disabled=" false  ||ro.yingzhuang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="报价" prop="baojia">
			<el-input-number v-model="ruleForm.baojia" placeholder="报价" :readonly="ro.baojia"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="装修风格" prop="zhuangxiufengge">
            <el-input v-model="ruleForm.zhuangxiufengge" 
                placeholder="装修风格" clearable :disabled=" false  ||ro.zhuangxiufengge"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="设计时间" prop="shejishijian">
              <el-date-picker
				  :disabled=" false  ||ro.shejishijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.shejishijian" 
                  type="datetime"
                  placeholder="设计时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="业主账号" prop="yezhuzhanghao">
            <el-input v-model="ruleForm.yezhuzhanghao" 
                placeholder="业主账号" clearable :disabled=" false  ||ro.yezhuzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="业主姓名" prop="yezhuxingming">
            <el-input v-model="ruleForm.yezhuxingming" 
                placeholder="业主姓名" clearable :disabled=" false  ||ro.yezhuxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="房屋名称" prop="fangwumingcheng">
            <el-input v-model="ruleForm.fangwumingcheng" 
                placeholder="房屋名称" clearable :disabled=" false  ||ro.fangwumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="楼层" prop="louceng">
            <el-input v-model="ruleForm.louceng" 
                placeholder="楼层" clearable :disabled=" false  ||ro.louceng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="房间号" prop="fangjianhao">
            <el-input v-model="ruleForm.fangjianhao" 
                placeholder="房间号" clearable :disabled=" false  ||ro.fangjianhao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="面积" prop="mianji">
            <el-input v-model="ruleForm.mianji" 
                placeholder="面积" clearable :disabled=" false  ||ro.mianji"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="房型" prop="fangxing">
            <el-input v-model="ruleForm.fangxing" 
                placeholder="房型" clearable :disabled=" false  ||ro.fangxing"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="位置" prop="weizhi">
            <el-input v-model="ruleForm.weizhi" 
                placeholder="位置" clearable :disabled=" false  ||ro.weizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="设计方案" prop="shejifangan">
            <editor 
                :style='{"minHeight":"250px","padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#eee","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.shejifangan" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#F5BB00","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#333","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				gongsimingcheng : false,
				fuzeren : false,
				gongsifengmian : false,
				lianxifangshi : false,
				kongjian : false,
				ruanzhuang : false,
				yingzhuang : false,
				baojia : false,
				zhuangxiufengge : false,
				shejishijian : false,
				shejifangan : false,
				yezhuzhanghao : false,
				yezhuxingming : false,
				fangwumingcheng : false,
				louceng : false,
				fangjianhao : false,
				mianji : false,
				fangxing : false,
				weizhi : false,
				ispay : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          gongsimingcheng: '',
          fuzeren: '',
          gongsifengmian: '',
          lianxifangshi: '',
          kongjian: '',
          ruanzhuang: '',
          yingzhuang: '',
          baojia: '',
          zhuangxiufengge: '',
          shejishijian: '',
          shejifangan: '',
          yezhuzhanghao: '',
          yezhuxingming: '',
          fangwumingcheng: '',
          louceng: '',
          fangjianhao: '',
          mianji: '',
          fangxing: '',
          weizhi: '',
          ispay: '',
        },


        rules: {
          gongsimingcheng: [
          ],
          fuzeren: [
          ],
          gongsifengmian: [
          ],
          lianxifangshi: [
          ],
          kongjian: [
          ],
          ruanzhuang: [
          ],
          yingzhuang: [
          ],
          baojia: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          zhuangxiufengge: [
          ],
          shejishijian: [
          ],
          shejifangan: [
          ],
          yezhuzhanghao: [
          ],
          yezhuxingming: [
          ],
          fangwumingcheng: [
          ],
          louceng: [
          ],
          fangjianhao: [
          ],
          mianji: [
          ],
          fangxing: [
          ],
          weizhi: [
          ],
          ispay: [
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.shejishijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='gongsimingcheng'){
              this.ruleForm.gongsimingcheng = obj[o];
              this.ro.gongsimingcheng = true;
              continue;
            }
            if(o=='fuzeren'){
              this.ruleForm.fuzeren = obj[o];
              this.ro.fuzeren = true;
              continue;
            }
            if(o=='gongsifengmian'){
              this.ruleForm.gongsifengmian = obj[o].split(",")[0];
              this.ro.gongsifengmian = true;
              continue;
            }
            if(o=='lianxifangshi'){
              this.ruleForm.lianxifangshi = obj[o];
              this.ro.lianxifangshi = true;
              continue;
            }
            if(o=='kongjian'){
              this.ruleForm.kongjian = obj[o];
              this.ro.kongjian = true;
              continue;
            }
            if(o=='ruanzhuang'){
              this.ruleForm.ruanzhuang = obj[o];
              this.ro.ruanzhuang = true;
              continue;
            }
            if(o=='yingzhuang'){
              this.ruleForm.yingzhuang = obj[o];
              this.ro.yingzhuang = true;
              continue;
            }
            if(o=='baojia'){
              this.ruleForm.baojia = obj[o];
              this.ro.baojia = true;
              continue;
            }
            if(o=='zhuangxiufengge'){
              this.ruleForm.zhuangxiufengge = obj[o];
              this.ro.zhuangxiufengge = true;
              continue;
            }
            if(o=='shejishijian'){
              this.ruleForm.shejishijian = obj[o];
              this.ro.shejishijian = true;
              continue;
            }
            if(o=='shejifangan'){
              this.ruleForm.shejifangan = obj[o];
              this.ro.shejifangan = true;
              continue;
            }
            if(o=='yezhuzhanghao'){
              this.ruleForm.yezhuzhanghao = obj[o];
              this.ro.yezhuzhanghao = true;
              continue;
            }
            if(o=='yezhuxingming'){
              this.ruleForm.yezhuxingming = obj[o];
              this.ro.yezhuxingming = true;
              continue;
            }
            if(o=='fangwumingcheng'){
              this.ruleForm.fangwumingcheng = obj[o];
              this.ro.fangwumingcheng = true;
              continue;
            }
            if(o=='louceng'){
              this.ruleForm.louceng = obj[o];
              this.ro.louceng = true;
              continue;
            }
            if(o=='fangjianhao'){
              this.ruleForm.fangjianhao = obj[o];
              this.ro.fangjianhao = true;
              continue;
            }
            if(o=='mianji'){
              this.ruleForm.mianji = obj[o];
              this.ro.mianji = true;
              continue;
            }
            if(o=='fangxing'){
              this.ruleForm.fangxing = obj[o];
              this.ro.fangxing = true;
              continue;
            }
            if(o=='weizhi'){
              this.ruleForm.weizhi = obj[o];
              this.ro.weizhi = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yezhuzhanghao!=''&&json.yezhuzhanghao) || json.yezhuzhanghao==0){
                this.ruleForm.yezhuzhanghao = json.yezhuzhanghao
            }
            if((json.yezhuxingming!=''&&json.yezhuxingming) || json.yezhuxingming==0){
                this.ruleForm.yezhuxingming = json.yezhuxingming
            }
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`fangwusheji/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('fangwusheji/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`fangwusheji/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`fangwusheji/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      gongsifengmianUploadChange(fileUrls) {
          this.ruleForm.gongsifengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 180px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  border: 1px solid #ddd;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
	  border: 1px solid #ddd;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  border: 1px solid #ddd;
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  border: 1px solid #ddd;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
	  border: 1px solid #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #fff;
	  width: 200px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  border: 1px solid #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #fff;
	  width: 200px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  border: 1px solid #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #fff;
	  width: 200px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  border: 1px solid #ddd;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
