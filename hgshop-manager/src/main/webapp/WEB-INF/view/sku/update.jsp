<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        

<div class="container-fluid">
	<form action="" id="skuForm">	
		<div class="form-group row">
		    <label for="goodsName" class="col-sm-2 col-form-label">spu名称</label>
		    <div class="col-sm-4">
		    	<input type="hidden" name="spuId" value="${sku.spu.id}">	
		      <input type="text" class="form-control" id="goodsName" disabled="disabled" name="goodsName" value="${sku.spu.goodsName}" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="skutitle" class="col-sm-2 col-form-label">sku名称</label>
		    <div class="col-sm-4">
		    	<input type="hidden" class="form-control"  name="id" value="${sku.id }">
		      <input type="text" class="form-control"  name="title" value="${sku.title }">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="skutitle" class="col-sm-2 col-form-label">规格</label>
		    <div class="col-sm-4">
		      <table class="table" id="specTable">
		      	<tr>
		      		<th>规格名称</th>
		      		<th>属性值</th>
		      		<th><button type="button" class="btn btn-light" onclick="addLine()">添加</button> </th>
		      	</tr>
		      	
		      	<c:forEach items="${sku.options }" var="opt" varStatus="index">
		      	<tr>
		      		<td>
		      			<!-- 第一个下拉框 -->
		      			<select  class="specSelect" name="options[${index.index}].specId" data-toggle="${opt.id}" onchange="specChange($(this),${opt.id})">
		      			<option value="">请选择</option>
		      			<c:forEach items="${specList}" var="spec">
		      		 		<option value="${spec.id}" ${opt.specId==spec.id?'selected':''}>${spec.specName}</option>
		      		 		</c:forEach>
		      		 	</select>
		      		 </td>
		      		<td>
		      			<!-- 第二个下拉框 -->
		      			<select name="options[${index.index}].id"></select>
		      		</td>
		      		<td>
						<!-- 放删除按钮 -->
						<button type="button" class="btn btn-danger btn-sm" onclick="removeLine($(this))">移除</button>
		      		</td>
		      	</tr>
		      	</c:forEach>
		      </table>
		    </div>
		 </div>
		 
		 <div class="form-group row">
		    <label for="sellPoint" class="col-sm-2 col-form-label">卖点</label>
		    <div class="col-sm-4">
		      <input type="text" id="sellPoint" class="form-control"  name="sellPoint" value="${sku.sellPoint }">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="price" class="col-sm-2 col-form-label">价格</label>
		    <div class="col-sm-3">
		      <input type="number" id="price" class="form-control"  name="price" value="${sku.price }">
		    </div>
		    <label for="price" class="col-sm-2 col-form-label">库存</label>
		    <div class="col-sm-3">
		      <input type="number" id="stockCount" class="form-control"  name="stockCount" value="${sku.stockCount }">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="costPrice" class="col-sm-2 col-form-label">成本</label>
		    <div class="col-sm-3">
		      <input type="number" id="costPrice" class="form-control"  name="costPrice"  value="${sku.costPrice }">
		    </div>
		    <label for="marketPrice" class="col-sm-2 col-form-label">市价</label>
		    <div class="col-sm-3">
		      <input type="number" id="marketPrice" class="form-control"  name="marketPrice" value="${sku.marketPrice }">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="barcode" class="col-sm-2 col-form-label">条形码</label>
		    <div class="col-sm-4">
		      <input type="text" id="barcode" class="form-control"  name="barcode" value="${sku.barcode }">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="imageFile" class="col-sm-2 col-form-label">图片</label>
		    <div class="col-sm-4">
		      <input type="file" id="imageFile" class="form-control"  name="imageFile" >
		      <img alt="" src="/pic/${sku.image }" style="width: 50px;height: 50px">
		    </div>
		 </div>
		 <div class="form-group row">
		    <label for="cartThumbnailFile" class="col-sm-2 col-form-label">购物车图</label>
		    <div class="col-sm-4">
		      <input type="file" id="cartThumbnailFile" class="form-control"  name="cartThumbnailFile" >
		    	 <img alt="" src="/pic/${sku.cartThumbnail }" style="width: 50px;height: 50px">
		    </div>
		 </div>	
		  <div class="form-group row">
		  	<button type="button" class="btn btn-primary btn-lg btn-block" onclick="commitData()">提交数据</button>
		  </div>	 


	</form>

</div>
<script type="text/javascript">

	//提交数据
	function commitData(){
		
		var formData = new FormData($("#skuForm")[0])
		alert(formData)
		$.ajax({
			url:'./sku/update',
			type:'post',
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){
				if(result){
					alert('修改成功')
					$("#workContent").load('./sku/list');
				}else{
					alert('修改失败')
				}
			}
		})
	}
	
	// 两个下拉框联动的效果
	function specChange(selObj,selId){
		// 得到规格id
		var specId=selObj.val();
		$.post('./sku/getSpecOptions',{specId:specId},function(data){
			var selOption= selObj.parent().next().children(0);
			selOption.empty();
			for(var i=0;i<data.length;i++ ){
				//selOption.append('<option value="'+data[i].id+'">'+data[i].optionName+'</option>')
				 if(selId==data[i].id){
					selOption.append('<option value="'+data[i].id+'" selected >'+data[i].optionName+'</option>')
				}else{
					selOption.append('<option value="'+data[i].id+'">'+data[i].optionName+'</option>')
				} 
			}
		});
		
	}
	
	// 触发下拉框的事件
	$(".specSelect").each(function(){
		var optId= $(this).attr('data-toggle')
		//alert(optId)
		specChange($(this),optId)
	})
	
	
	//移除一行
	function removeLine(btnObj){
		btnObj.parent().parent().remove();
	}
	
	var index=1;
	function addLine(){
		
		$('#specTable').append(`
				<tr>
	      		<td><select name="options[`+index+`].specId" onchange="specChange($(this))">
	      			<option value="">请选择</option>
	      			<c:forEach items="${specList}" var="spec">
	      		 		<option value="${spec.id}">${spec.specName}</option>
	      		 		</c:forEach>
	      		 	</select>
	      		 </td>
	      		<td>
	      			<select name="options[`+index+`].id"></select>
	      		</td>
	      		<td>
	      			<button type="button" class="btn btn-danger btn-sm" onclick="removeLine($(this))">移除</button>
	      		</td>
	      	</tr>
		`)
		index++
	}
	
	
	
</script>     