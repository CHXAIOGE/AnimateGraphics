# AnimateGraphics
Wrapper support for webp gif apng.Core Module

support for apng webp and gif currently

## ModulesSample
https://github.com/CHXAIOGE/ModulesSample

## module aar dependencies:

### apng module:

  https://github.com/CHXAIOGE/ApngSequenceModule
  
  https://github.com/CHXAIOGE/ApngSequence

### webp & gif module

  https://github.com/CHXAIOGE/FrameSequence
  
  https://github.com/CHXAIOGE/FrameSequenceModule

## usage:
register support:

      ApngLoader.init(this);
      Graphics.get().getRegistry().append(new FrameSequenceModule(), FrameSequenceLoader.class);
      Graphics.get().getRegistry().append(new ApngSequenceModule(), ApngSupportLoader.class);

### input : 
  file[strongly recommanded] or inputstream 

### load :

    try {
      Graphics.get().load(rawImageStream , new Target() {
          @Override
          public void onLoadFailed() {
              
          }

          @Override
          public void onResourceReady(DrawableWrapper drawableWrapper) {
             
              drawableWrapper.setLoopMode(DrawableHelper.REPEAT_MODE_FINITE);
              drawableWrapper.setRepeatCount(1);
              drawableWrapper.setPlayListener(new PlayListener() {
                  @Override
                  public void onPlayFinished() {

                  }
              });
              drawableWrapper.start();
          }
      }).into(imageView);
    } catch (Exception e) {

    }

