<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://localhost:8080/springbootlqyk36m6/upload/11.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center bottom","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #f6f6f6","padding":"30px 5% 20px 45%","margin":"50px auto 50px","borderRadius":"0px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230930/f52d5a109d7248d69a33749b059f901d.jpg) no-repeat left center / 50% 101%,#fff","width":"75%","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0px","margin":"0px auto 20px","borderColor":"#eee","color":"#57759b","textAlign":"center","display":"inline-block","background":"#fff","borderWidth":"0px","width":"100%","lineHeight":"40px","fontSize":"24px","borderStyle":"solid","fontWeight":"600"}' class="title">家居装修管理系统注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('yezhuzhanghao')?'required':''">业主账号：</div>
					<el-input  v-model="ruleForm.yezhuzhanghao"  autocomplete="off" placeholder="业主账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('yezhuxingming')?'required':''">业主姓名：</div>
					<el-input  v-model="ruleForm.yezhuxingming"  autocomplete="off" placeholder="业主姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yezhuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yezhutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
					<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yezhu'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
					<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gongsimingcheng')?'required':''">装修公司名称：</div>
					<el-input  v-model="ruleForm.gongsimingcheng"  autocomplete="off" placeholder="装修公司名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('fuzeren')?'required':''">负责人：</div>
					<el-input  v-model="ruleForm.fuzeren"  autocomplete="off" placeholder="负责人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gongsifengmian')?'required':''">装修公司封面：</div>
                    <file-upload
                        tip="点击上传装修公司封面"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.gongsifengmian?ruleForm.gongsifengmian:''"
                        @change="gongsigongsifengmianUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gongsiyouxiang')?'required':''">装修公司邮箱：</div>
					<el-input  v-model="ruleForm.gongsiyouxiang"  autocomplete="off" placeholder="装修公司邮箱"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gongsidizhi')?'required':''">装修公司地址：</div>
					<el-input  v-model="ruleForm.gongsidizhi"  autocomplete="off" placeholder="装修公司地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('chuanglishijian')?'required':''">创立时间：</div>
                    <el-date-picker
                        format="yyyy 年 MM 月 dd 日"
                        value-format="yyyy-MM-dd"
                        v-model="ruleForm.chuanglishijian"
                        type="date"
                        placeholder="创立时间"
                    ></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"block","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='gongsi'">
					<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","display":"inline-block","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('gongsijianjie')?'required':''">装修公司简介：</div>
					<editor
						style="min-width: 200px; max-width: 600px;"
						:style='{"width":"100%","height":"auto"}'
						v-model="ruleForm.gongsijianjie" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<button :style='{"border":"2px solid #57759b","cursor":"pointer","padding":"0px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#57759b","display":"inline-block","letterSpacing":"4px","outline":"none","borderRadius":"0px","background":"none","width":"49%","fontSize":"18px","fontWeight":"600","height":"50px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 0px","margin":"10px 0 0","color":"#57759b","textAlign":"right","display":"inline-block","width":"49%","lineHeight":"1","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yezhuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yezhu'){
				this.ruleForm = {
					yezhuzhanghao: '',
					mima: '',
					yezhuxingming: '',
					xingbie: '',
					lianxifangshi: '',
					touxiang: '',
					pquestion: '',
					panswer: '',
				}
			}
			if(this.tableName=='gongsi'){
				this.ruleForm = {
					gongsimingcheng: '',
					mima: '',
					fuzeren: '',
					gongsifengmian: '',
					lianxifangshi: '',
					gongsiyouxiang: '',
					gongsidizhi: '',
					chuanglishijian: '',
					shejituandui: '',
					gongsijianjie: '',
					sfsh: '',
					shhf: '',
					clicktime: '',
					clicknum: '',
					storeupnum: '',
				}
			}
			if ('yezhu' == this.tableName) {
				this.rules.yezhuzhanghao = [{ required: true, message: '请输入业主账号', trigger: 'blur' }]
			}
			if ('yezhu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yezhu' == this.tableName) {
				this.rules.yezhuxingming = [{ required: true, message: '请输入业主姓名', trigger: 'blur' }]
			}
			if ('gongsi' == this.tableName) {
				this.rules.gongsimingcheng = [{ required: true, message: '请输入装修公司名称', trigger: 'blur' }]
			}
			if ('gongsi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.yezhuxingbieOptions = "男,女".split(',')
			this.ruleForm.chuanglishijian = this.getCurDate()
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yezhutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        gongsigongsifengmianUploadChange(fileUrls) {
            this.ruleForm.gongsifengmian = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yezhuzhanghao) && `yezhu` == this.tableName){
						this.$message.error(`业主账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yezhu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yezhu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.yezhuxingming) && `yezhu` == this.tableName){
						this.$message.error(`业主姓名不能为空`);
						return
					}
					if(`yezhu` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			  if(this.tableName=='gongsi'){
				  this.ruleForm.sfsh = '待审核'
			  }
					if((!this.ruleForm.gongsimingcheng) && `gongsi` == this.tableName){
						this.$message.error(`装修公司名称不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `gongsi` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `gongsi` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
            if(this.ruleForm.gongsifengmian!=null) {
                this.ruleForm.gongsifengmian = this.ruleForm.gongsifengmian.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`gongsi` == this.tableName && this.ruleForm.gongsiyouxiang &&(!this.$validate.isEmail(this.ruleForm.gongsiyouxiang))){
						this.$message.error(`装修公司邮箱应输入邮件格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://localhost:8080/springbootlqyk36m6/upload/11.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #62779c;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #62779c;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #62779c;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #999;
						background: #fff;
						width: 100%;
						font-size: 14px;
						border-color: #62779c;
						border-width: 0 0 2px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form ::v-deep .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form ::v-deep .upload .upload-img {
		  		  border: 2px solid #62779c;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #62779c;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 40px;
		  		  text-align: center;
		  		  height: 40px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  border: 2px solid #62779c;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #62779c;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 40px;
		  		  text-align: center;
		  		  height: 40px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  border: 2px solid #62779c;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #62779c;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 40px;
		  		  text-align: center;
		  		  height: 40px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 6px;
				content: "*";
				order: 1;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
