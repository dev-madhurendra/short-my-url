import  { ReactNode } from "react";
import { Typography, TypographyProps } from "@mui/material";
import { typography_DataTestId } from "../../../utils/constants";

interface CustomTypographyProps extends TypographyProps {
  text: ReactNode;
  
}
const MuiTypography = ({ variant, sx, text, ...rest }: CustomTypographyProps) => (
  <Typography data-testid={typography_DataTestId} variant={variant} sx={sx} {...rest}>
    {text}
  </Typography>
);

export default MuiTypography;
