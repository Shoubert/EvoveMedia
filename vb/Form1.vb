Public Class StadiumSeats
    ' Ticket prices per seat class
    Const decClassA_RATE As Decimal = 15
    Const decClassB_RATE As Decimal = 12
    Const decClassC_RATE As Decimal = 9

    Private Sub btnCalculate_Click(sender As System.Object, e As System.EventArgs) Handles btnCalculate.Click
        Dim intClassA, intClassB, intClassC As Integer
        If Not (ReadCount(txtClassA, intClassA) AndAlso ReadCount(txtClassB, intClassB) AndAlso ReadCount(txtClassC, intClassC)) Then
            Return
        End If

        Dim decRevenueA As Decimal = intClassA * decClassA_RATE
        Dim decRevenueB As Decimal = intClassB * decClassB_RATE
        Dim decRevenueC As Decimal = intClassC * decClassC_RATE

        txtRevenueA.Text = decRevenueA.ToString("C")
        txtRevenueB.Text = decRevenueB.ToString("C")
        txtRevenueC.Text = decRevenueC.ToString("C")
        txtTotalRevenue.Text = (decRevenueA + decRevenueB + decRevenueC).ToString("C")
    End Sub

    ' Blank counts as 0; anything that is not a whole number >= 0 is rejected.
    Private Function ReadCount(box As TextBox, ByRef value As Integer) As Boolean
        If box.Text.Trim() = "" Then
            value = 0
            Return True
        End If
        If Integer.TryParse(box.Text.Trim(), value) AndAlso value >= 0 Then
            Return True
        End If
        MessageBox.Show("Enter a whole number of tickets (0 or more).", "Stadium Seats")
        box.Focus()
        box.SelectAll()
        Return False
    End Function

    Private Sub btnClear_Click(sender As System.Object, e As System.EventArgs) Handles btnClear.Click
        txtClassA.Clear()
        txtClassB.Clear()
        txtClassC.Clear()
        txtRevenueA.Clear()
        txtRevenueB.Clear()
        txtRevenueC.Clear()
        txtTotalRevenue.Clear()
        txtClassA.Focus()
    End Sub

    Private Sub btnExit_Click(sender As System.Object, e As System.EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub
End Class
