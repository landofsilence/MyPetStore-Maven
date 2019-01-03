<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<form action="NewOrder" method="get">
	<input type="hidden" name="skipType" value="2">
<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td><select name="cardType" >
				<option value="China Construction Bank">China Construction Bank</option>
				<option value="AGRICULTURAL BANK OF CHINA">AGRICULTURAL BANK OF CHINA</option>
			</select> </td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td> <input type="text" name="creditCard"/>* Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input type="text" name="expiryDate"/></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="billToFirstName" value="${sessionScope.account.firstName}"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="billToLastName" value="${sessionScope.account.lastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="billAddress1" value="${sessionScope.account.address1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="billAddress2" value="${sessionScope.account.address2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="billCity" value="${sessionScope.account.city}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="billState"   value="${sessionScope.account.state}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><<input type="text" size="10" name="billZip"  value="${sessionScope.account.zip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="billCountry"  value="${sessionScope.account.country}"/></td>
		</tr>

		<tr>
			<td colspan=2><label><input id="shipTo" name="shipAddress" type="checkbox" value="true" />Ship to different address... </label>
			</td>
		</tr>

	</table>

	<div id="shipForm" class="hiddenCatalog" >
		<table>
			<tr>
				<th colspan=2>Shipping Address</th>
			</tr>

			<tr>
				<td>First name:</td>
				<td><input type="text" name="shipToFirstName" value="${sessionScope.account.firstName}"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text" name="shipToLastName" value="${sessionScope.account.lastName}"/></td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td><input type="text" size="40" name="shipAddress1" value="${sessionScope.account.address1}"/></td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td><input type="text" size="40" name="shipAddress2" value="${sessionScope.account.address2}"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="shipCity" value="${sessionScope.account.city}"/></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" size="4" name="shipState"   value="${sessionScope.account.state}"/></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><<input type="text" size="10" name="shipZip"  value="${sessionScope.account.zip}"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" size="15" name="shipCountry"  value="${sessionScope.account.country}"/></td>
			</tr>


		</table>
	</div>

	<input type="submit" name="newOrder" value="Confirm"/>
</form>
</div>




<script type="text/javascript">
    $("#shipTo").click(function () {
        console.log($("#shipTo").value);
        if($("#shipTo").is(':checked')){
        $("#shipForm").removeClass('hiddenCatalog');
        }
        else{
            $("#shipForm").addClass('hiddenCatalog');
		}
    });

</script>

<%@ include file="../common/IncludeBottom.jsp"%>