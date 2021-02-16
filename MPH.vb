Public Class frmDistanceCalc 

Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click 
' Declare Variables 
Dim intTotal As Integer = 0 ' Loop Counter 
Dim intDistance As Integer = 0 ' Holds the distance 
Dim decSpeed As Decimal = 0 ' Speed of the vehicle 
Dim decTime As Decimal = 0 ' Time vehicle is driving 
Dim decTotal As Decimal = 0 ' Total distance covered 
Dim strSpeedInput As String ' User input for speed 
Dim strTimeInput As String ' User input for time 

' Get speed from the user 
strSpeedInput = InputBox("Enter the speed (in miles per hour) of the vehicle:") 

' Convert the input into a decimal. 
If Decimal.TryParse(strSpeedInput, decSpeed) Then 
' Get time from user 
strTimeInput = InputBox("Enter the time (in hours) that the vehicle is traveling:") 
' Convert the input to a decimal. 
If Decimal.TryParse(strTimeInput, decTime) Then 
' Calculate the distance 
decTotal = decTime * decSpeed 

' Create a string to display the speed 
strSpeedInput = "Vehicle Speed: " & decSpeed.ToString() & " MPH" 
lstDistance.Items.Add(strSpeedInput) 

' Create a string to display time traveled 
lstDistance.Items.Add("Time Traveled: " & decTime.ToString() & " Hours") 

' Create a string to display Hours and Distance Traveled 
lstDistance.Items.Add("Hours Distance Traveled") 

' Create a string to represent a separation line 
lstDistance.Items.Add("-----------------... 

For intTotal = 1 To 7 
' Calculate the distance 
intDistance = CInt(intTotal * decSpeed) 
lstDistance.Items.Add(intTotal.ToString & " " & intDistance.ToString) 
Next 

' Add Total to lstDistance 
lstDistance.Items.Add("Total Distance: " & decTotal.ToString) 
Else 
MessageBox.Show("Error: Enter a numeric value for Time.") 
End If 
Else 
MessageBox.Show("Error: Enter a numeric value for Speed.") 
End If 
End Sub 

Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click 
' Closes the form. 
Me.Close() 
End Sub 
End Class
