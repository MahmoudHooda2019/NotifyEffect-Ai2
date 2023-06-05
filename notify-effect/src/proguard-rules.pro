# Add any ProGuard configurations specific to this
# extension here.

-keep public class me.aemo.notifyeffect.NotifyEffect {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'me/aemo/notifyeffect/repack'
-flattenpackagehierarchy
-dontpreverify
