package com.longyi.lib_download.file_upload

/**
 * Created by Aller on 2019/8/20.
 */
class ProgressRequestBody:RequestBody() {
    private File mFile;
    private String mPath;
    private String mMediaType;
    private UploadCallbacks mListener;

    private int mEachBufferSize = 1024;

    private ResponseBody responseBody;

    private UploadCallbacks mDownloadListener;

    // BufferedSource 是okio库中的输入流，这里就当作inputStream来使用。
    private BufferedSource bufferedSource;

    int count = 0;


    public ProgressRequestBody(final File file, String mediaType, final UploadCallbacks listener) {
        mFile = file;
        mMediaType = mediaType;
        mListener = listener;
    }


    public ProgressRequestBody(final File file, String mediaType, int eachBufferSize, final UploadCallbacks listener) {
        mFile = file;
        mMediaType = mediaType;
        mEachBufferSize = eachBufferSize;
        mListener = listener;
    }


    @Override
    public MediaType contentType() {
        // i want to upload only images
        return MediaType.parse(mMediaType);
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if (sink instanceof Buffer) {
            return;
        }
        long fileLength = mFile.length();
        byte[] buffer = new byte[mEachBufferSize];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;


        try {
            int read;
            Handler handler = new Handler(Looper.getMainLooper());
            while ((read = in.read(buffer)) != -1) {
                // update progress on UI thread
                handler.post(new ProgressUpdater(uploaded, fileLength, count));
                uploaded += read;
                sink.write(buffer, 0, read);
            }
            if (uploaded == fileLength) {
                count = 1;
            }
        } finally {
            in.close();
        }
    }

    private class ProgressUpdater implements Runnable {
        private long mUploaded;
        private long mTotal;
        private int mCount;

        public ProgressUpdater(long uploaded, long total, int count) {
            mUploaded = uploaded;
            mTotal = total;
            mCount = count;
        }

        @Override
        public void run() {
            mListener.onProgressUpdate((int) (100 * mUploaded / mTotal), mCount);
        }
    }
}