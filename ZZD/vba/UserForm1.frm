VERSION 5.00
Begin {C62A69F0-16DC-11CE-9E98-00AA00574A4F} UserForm1 
   Caption         =   "UserForm1"
   ClientHeight    =   7650
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   5265
   OleObjectBlob   =   "UserForm1.frx":0000
   StartUpPosition =   1  'CenterOwner
End
Attribute VB_Name = "UserForm1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub cancle_Click()
Me.Hide
End Sub

Private Sub clearForm()
txbName.Value = ""
txbNumber.Value = ""
lsbCity.clear

With lsbCity
    .AddItem "San Francisco"
    .AddItem "Oakland"
    .AddItem "Richmond"
End With

End Sub

Private Sub clear_Click()
clearForm
End Sub

Private Sub CheckBox2_Click()

End Sub

Private Sub Label2_Click()

End Sub

Private Sub name_Change()

End Sub

Private Sub lsbCity_Click()

End Sub

Private Sub SpinButton1_Change()

End Sub

Private Sub txbName_Change()

End Sub

Private Sub UserForm_Click()

End Sub
