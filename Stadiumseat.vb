Public Class StadiumSeats

    Private Sub btnCalculate_Click(sender As System.Object, e As System.EventArgs) Handles btnCalculate.Click
        Dim intClassA As Integer
        Dim intClassB As Integer
        Dim intClassC As Integer
        Const decClassA_RATE As Decimal = 15
        Const decClassB_RATE As Decimal = 12
        Const decClassB_RATE As Decimal = 9
        Dim RevenueA As Decimal
        Dim RevenueB As Decimal
        Dim RevenueC As Decimal
        Dim TotalRevenue As Decimal
        intClassA = txtClassA.Text
        intClassB = txtClassB.Text
        intClassC = txtClassB.Text
        txtRevenueA.Text = intClassA * decClassA_RATE
        txtRevenueB.Text = intClassB * decClassB_RATE
        txtRevenueC.Text = intClassC * decClassB_RATE
        txtTotalRevenue.Text = txtClassA.Text + txtClassB.Text + txtClassC.Text


        


    End Sub

    Private Sub btnClear_Click(sender As System.Object, e As System.EventArgs) Handles btnClear.Click
        txtClassA.Clear()
        txtClassB.Clear()
        txtClassC.Clear()
        txtRevenueA.Clear()
        txtRevenueB.Clear()
        txtRevenueC.Clear()
        txtTotalRevenue.Clear()
        
    End Sub

    Private Sub btnExit_Click(sender As System.Object, e As System.EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub
End Class