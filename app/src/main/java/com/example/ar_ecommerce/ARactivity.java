package com.example.ar_ecommerce;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.HashMap;
import java.util.Objects;

public class ARactivity extends AppCompatActivity {
    private int clickNo = 0;
    private ArFragment arCam;
    private String name;
    HashMap<String, ARProductData> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aractivity);

        // Populating the hashMap with product data
        hashMap.put("T-Heart", new ARProductData(R.raw.divyaheart, 0.75f, 0.85f)); // only bulb First-UI
        hashMap.put("C2-Brain", new ARProductData(R.raw.ajaybrain, 0.70f, 0.75f));//SECOND UI
        hashMap.put("C3-lungs", new ARProductData(R.raw.ajaylungs, 0.60f, 0.65f));//3RD ui
        hashMap.put("fc4-spinal",new ARProductData(R.raw.ajayspinal, 0.66f,0.69f));//4TH
        hashMap.put("pc5-Kidnyes", new ARProductData(R.raw.ajaykiney3, 0.75f, 0.85f));//5th UI
        hashMap.put("sc6-urinal", new ARProductData(R.raw.ajayurinal, 0.70f, 0.75f));// 6th UI



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }

        if (checkSystemSupport(this)) {
            arCam = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
            assert arCam != null;

            // Set onTap listener for the AR plane
            arCam.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
                clickNo++;
                if (clickNo == 1) {
                    // Create an anchor at the tapped location
                    Anchor anchor = hitResult.createAnchor();
                    ModelRenderable.builder()
                            .setSource(this, hashMap.get(name).getId())  // Set the model to load
                            .setIsFilamentGltf(true)
                            .build()
                            .thenAccept(modelRenderable -> {
                                Log.d("ARActivity", "Model loaded successfully: " + name);
                                addModel(anchor, modelRenderable);
                            })
                            .exceptionally(throwable -> {
                                Log.e("ARActivity", "Error loading model: " + name + " - " + throwable.getMessage());
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setMessage("Something is not right" + throwable.getMessage()).show();
                                return null;
                            });
                }
            });
        }
    }



    private void addModel(Anchor anchor, ModelRenderable modelRenderable) {
        // Create an AnchorNode to attach the model
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arCam.getArSceneView().getScene());

        // Create a TransformableNode for scaling the model
        TransformableNode model = new TransformableNode(arCam.getTransformationSystem());
        model.setParent(anchorNode);
        model.getScaleController().setMaxScale(hashMap.get(name).getMax());
        model.getScaleController().setMinScale(hashMap.get(name).getMin());
        model.setRenderable(modelRenderable);
        model.select();
    }

    public static boolean checkSystemSupport(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String openGlVersion = ((ActivityManager) Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE)))
                    .getDeviceConfigurationInfo().getGlEsVersion();
            if (Double.parseDouble(openGlVersion) >= 3.0) {
                return true;
            } else {
                Toast.makeText(activity, "App needs OpenGl Version 3.0 or later", Toast.LENGTH_SHORT).show();
                activity.finish();
                return false;
            }
        } else {
            Toast.makeText(activity, "App does not support required Build Version", Toast.LENGTH_SHORT).show();
            activity.finish();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ARactivity.this, MainActivity.class);
        intent.putExtra("name", "Sammitha S");
        startActivity(intent);
    }
}
