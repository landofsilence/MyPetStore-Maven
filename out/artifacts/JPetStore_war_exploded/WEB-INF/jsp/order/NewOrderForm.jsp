<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<form action="NewOrder" method="post">
	<input type="hidden" name="skipType" value="2">
<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td><select name="cardType" >
				<option selected="selected" value="China Construction Bank">China Construction Bank</option>
				<option value="AGRICULTURAL BANK OF CHINA">AGRICULTURAL BANK OF CHINA</option>
			</select> </td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td> <input type="text" name="creditCard"/>
            </td>
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
			<td><input type="text" size="10" name="billZip"  value="${sessionScope.account.zip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="billCountry"  value="${sessionScope.account.country}"/></td>
		</tr>

		<tr>
			<td colspan=2><label><input name="shipAddress" type="checkbox" value="true" />Ship to different address... </label>
			</td>
		</tr>

	</table>

	<input type="submit" name="newOrder" value="Confirm"/>
</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>