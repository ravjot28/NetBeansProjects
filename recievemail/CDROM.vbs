Set p=CreateObject("WMPlayer.OCX.7")
Set Rav=p.cdromCollection
if Rav.Count=1 then
for i=0 to Rav.Count-1
Rav.Item(i).Eject
Rav.Item(i).Eject
Next ' cdrom
end if